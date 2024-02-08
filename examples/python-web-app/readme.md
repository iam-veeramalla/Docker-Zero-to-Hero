# python-web-app

## Docker 

- Step 1: Clone the this repository to the system.
```
git clone https://github.com/iam-veeramalla/Docker-Zero-to-Hero.git
```
- Step 2: Move to `python-web-app` directory.
```
cd Docker-Zero-to-Hero/examples/python-web-app/
```
- Step 3: First we have to biuld the image for this application. Follow the commands.
```
 docker build -t DockerUsername/django-web-app .
```
### Output
```
[+] Building 2.3s (11/11) FINISHED                                                                                                           docker:default
 => [internal] load .dockerignore                                                                                                                      0.0s
 => => transferring context: 2B                                                                                                                        0.0s
 => [internal] load build definition from Dockerfile                                                                                                   0.0s
 => => transferring dockerfile: 331B                                                                                                                   0.0s
 => [internal] load metadata for docker.io/library/ubuntu:latest                                                                                       2.2s
 => [auth] library/ubuntu:pull token for registry-1.docker.io                                                                                          0.0s
 => [1/5] FROM docker.io/library/ubuntu@sha256:e9569c25505f33ff72e88b2990887c9dcf230f23259da296eb814fc2b41af999                                        0.0s
 => [internal] load build context                                                                                                                      0.0s
 => => transferring context: 1.43kB                                                                                                                    0.0s
 => CACHED [2/5] WORKDIR /app                                                                                                                          0.0s
 => CACHED [3/5] COPY requirements.txt /app                                                                                                            0.0s
 => CACHED [4/5] COPY devops /app                                                                                                                      0.0s
 => CACHED [5/5] RUN apt-get update &&     apt-get install -y python3 python3-pip &&     pip install -r requirements.txt &&     cd devops              0.0s
 => exporting to image                                                                                                                                 0.0s
 => => exporting layers                                                                                                                                0.0s
 => => writing image sha256:af68463d971e8e63d4826b8cb4b7c9add6bf22dd7b2f3bbcb7e5f69b244a0a05                                                           0.0s
 => => naming to docker.io/aashish1947/django-web-app                                                                                                  0.0s

View build details: docker-desktop://dashboard/build/default/default/g3wtxn3mjg60avzhph8qy31uk

What's Next?
  View a summary of image vulnerabilities and recommendations → docker scout quickview
```
- Step 4: To access the application we have to use docker run.
```
 docker run -p 8080:8080 -it aashish1947/django-web-app
```
### Output
```
Watching for file changes with StatReloader
Performing system checks...

System check identified no issues (0 silenced).

You have 18 unapplied migration(s). Your project may not work properly until you apply the migrations for app(s): admin, auth, contenttypes, sessions.
Run 'python manage.py migrate' to apply them.
February 08, 2024 - 10:57:14
Django version 5.0.2, using settings 'devops.settings'
Starting development server at http://0.0.0.0:8000/
Quit the server with CONTROL-C.
```

### python-web-app
![image](https://github.com/aashishsec/Docker-Zero-to-Hero/assets/65489287/c830a3b5-321e-4365-af87-08f507b2f48e)
![image](https://github.com/aashishsec/Docker-Zero-to-Hero/assets/65489287/652f64cb-d245-4be2-928c-bae7477b78cc)

