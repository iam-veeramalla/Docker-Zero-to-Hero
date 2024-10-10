import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;
import java.util.Random;

public class RandomImageWebApp extends HttpServlet {
    private String[] imagePaths = {
        "images/image1.jpg",
        "images/image2.jpg",
        "images/image3.jpg"
    };

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Random rand = new Random();
        int index = rand.nextInt(imagePaths.length);
        File file = new File(imagePaths[index]);

        resp.setContentType("image/jpeg");
        resp.setHeader("Content-Disposition", "inline");

        try (OutputStream out = resp.getOutputStream();
             FileInputStream in = new FileInputStream(file)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(8000);

        ServletContextHandler handler = new ServletContextHandler();
        handler.setContextPath("/");

        handler.addServlet(RandomImageWebApp.class, "/image");
        handler.addServlet(DefaultServlet.class, "/");

        handler.setResourceBase(".");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
