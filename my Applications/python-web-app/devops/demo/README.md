# Deplyoing The DJANGO application in Docker container
### Django:
Django is the Python web framework. If so, Django is a high-level Python web framework that encourages rapid development and clean, pragmatic design. It follows the model-view-template (MVT) architectural pattern and includes features such as an object-relational mapper (ORM), a URL routing system, a template engine, and a form handling library. Django is widely used for building web applications.

 Actually we write a simple  python code in views.py folder and wrote a html file in demo_site.html that is displayed in frontend.
 ## Explanation for views.py folder

 This code snippet defines a Django view, which is a Python function that takes a web request and returns a web response. Let's break down the code:

1. `from django.http import HttpResponse`: This imports the `HttpResponse` class from the `django.http` module. `HttpResponse` is a class used to create HTTP responses.

2. `from django.shortcuts import render`: This imports the `render` function from the `django.shortcuts` module. The `render` function is a shortcut method for loading a template, rendering it with a context, and returning an `HttpResponse` object with the rendered content.

3. `def index(request):`: This defines a view function called `index` that takes a `request` object as its argument. The `request` object represents the HTTP request from the client.

4. `return render(request, 'demo_site.html')`: This line uses the `render` function to render the `demo_site.html` template with an optional context (not provided in this example) and returns the result as an `HttpResponse` object. The `request` argument is passed to the `render` function to provide context information, such as the request's user, session, and other metadata.

In summary, this code defines a Django view function called `index` that renders the `demo_site.html` template and returns the rendered content as an HTTP response.
 ## Explanation for dockerfile

This Dockerfile describes the steps to create a Docker image for a Django application. Let's break down each part:

1. `FROM ubuntu`: This sets the base image to use for subsequent instructions. In this case, it's using Ubuntu as the base image.

2. `WORKDIR /app`: This sets the working directory inside the container to `/app`. Subsequent instructions will be executed from this directory.

3. `COPY requirements.txt /app`: This copies the `requirements.txt` file from the host machine to the `/app` directory inside the container. This file typically contains a list of Python packages required by the Django application.

4. `COPY devops /app`: This copies the `devops` directory from the host machine to the `/app` directory inside the container. This directory likely contains the Django project files.

5. `RUN apt-get update && \`: This updates the package list in the Ubuntu image.

6. `apt-get install -y python3 python3-pip && \`: This installs Python 3 and pip (Python package manager) in the Ubuntu image.

7. `pip install -r requirements.txt && \`: This installs the Python packages listed in the `requirements.txt` file using pip.

8. `cd devops`: This changes the working directory to the `devops` directory inside the container. Note that this command will not have any effect on subsequent commands, as each `RUN` instruction starts with a new shell.

9. `ENTRYPOINT ["python3"]`: This specifies the default executable to run when the container starts. In this case, it's set to `python3`.

10. `CMD ["manage.py", "runserver", "0.0.0.0:8000"]`: This provides the default arguments to the `ENTRYPOINT` command. It tells Docker to run `python3 manage.py runserver 0.0.0.0:8000` when the container starts. This command starts the Django development server, serving the application on all available network interfaces on port 8000.

Please note that this Dockerfile assumes the presence of a Django project in the `devops` directory and a `requirements.txt` file listing the required Python packages. Adjustments may be needed based on the actual project structure and requirements.

### what is the diffrence between entrypoint and cmd in docker file with example



 CMD: CMD instruction is used mentioning the startup scripts and commands for starting the services.
        This instruction will be executed at runtime of the docker container.
        When more then one CMD instruction is used inside Dockerfile, then only one CMD instruction will be used by Dockerfile , rest will be ignored!!

        
    
    CMD ["/opt/tomcat/bin/startup.sh"]
    CMD ["/opt/tomcat/bin/catalina.sh","force-start"]
    CMD ["/opt/tomcat/bin/catalina.sh","run"]
    
    
ENTRYPOINT: ENTRYPOINT instruction is used mentioning the startup scripts and commands for starting the services.
        - This instruction will be executed at runtime of the docker container.
        - When ENTRYPOINT is used we can mention more than one CMD instruction inside Dockerfile.
        - We can pass arguments as CMD to ENTRYPOINT instruction.
   
    
    ENTRYPOINT ["/opt/tomcat/bin/catalina.sh"]
    CMD ["run"]
    CMD ["force-start"]
    
    
- The settings.py si for entire information of what the ip's that you can whitelist,what is the database that are you going to connect,if you have any secure information these things was there in settings.py file,it will set the entire configuration for your django Project.
- The urls.py is responisble for serving the content.

  # Application Process

  - Install Python
```  
 yum install Python
 
sudo yum install python3-pip

sudo pip3 install Django

python3 -m django --version
```
### Creating a project

- If this is your first time using Django, you’ll have to take care of some initial setup. Namely, you’ll need to auto-generate some code that establishes a Django project – a collection of settings for an instance of Django, including database configuration, Django-specific options and application-specific settings.

From the command line, cd into a directory where you’d like to store your code, then run the following command:


``` django-admin startproject devops (Repo name) ```

- This will create a mysite directory in your current directory. If it didn’t work, see Problems running django-admin.

 ### The development server
Let’s verify your Django project works. Change into the outer mysite directory, if you haven’t already, and run the following commands:


``` python manage.py runserver ```

``` python manage.py startapp polls ```

  
