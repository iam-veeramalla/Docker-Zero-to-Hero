# first-docker-file

- Step 1: Clone the this repository to the system.
```
git clone https://github.com/iam-veeramalla/Docker-Zero-to-Hero.git
```
- Step 2: Move to `python-web-app` directory.
```
cd Docker-Zero-to-Hero/examples/first-docker-file/
```
- Step 3: First we have to biuld the image for this application. Follow the commands.
```
docker build -t aashish1947/first-docker-file .
```
### Output
```
2024/02/08 16:40:30 http2: server: error reading preface from client //./pipe/docker_engine: file has already been closed
[+] Building 2.0s (10/10) FINISHED                                                                                                           docker:default
 => [internal] load .dockerignore                                                                                                                      0.0s
 => => transferring context: 2B                                                                                                                        0.0s
 => [internal] load build definition from Dockerfile                                                                                                   0.0s
 => => transferring dockerfile: 417B                                                                                                                   0.0s
 => [internal] load metadata for docker.io/library/ubuntu:latest                                                                                       1.9s
 => [auth] library/ubuntu:pull token for registry-1.docker.io                                                                                          0.0s
 => [1/4] FROM docker.io/library/ubuntu:latest@sha256:e9569c25505f33ff72e88b2990887c9dcf230f23259da296eb814fc2b41af999                                 0.0s
 => [internal] load build context                                                                                                                      0.0s
 => => transferring context: 57B                                                                                                                       0.0s
 => CACHED [2/4] WORKDIR /app                                                                                                                          0.0s
 => CACHED [3/4] COPY . /app                                                                                                                           0.0s
 => CACHED [4/4] RUN apt-get update && apt-get install -y python3 python3-pip                                                                          0.0s
 => exporting to image                                                                                                                                 0.0s
 => => exporting layers                                                                                                                                0.0s
 => => writing image sha256:0c985aa5af48d82f144a3583bc03e2e952116559dda8c5eb48e0e1cefce159ee                                                           0.0s
 => => naming to docker.io/aashish1947/first-docker-file                                                                                               0.0s

View build details: docker-desktop://dashboard/build/default/default/umurapj3hm8ef2kiapp1lp9w1

What's Next?
  View a summary of image vulnerabilities and recommendations → docker scout quickview
```
- Step 4: To access the application we have to use docker run.
```
docker run -it aashish1947/first-docker-file
```
### Output
```
Hello World
```

### 

- Step 5: If u want to push this docker to your's Docker repository. Follow this commmands.
```
 docker push DockerUserName/django-web-app
```

