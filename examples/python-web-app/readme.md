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
- Step 4: To run the application we have to use docker run.
```
 docker run -p 8080:8080 -it aashish1947/django-web-app
```
