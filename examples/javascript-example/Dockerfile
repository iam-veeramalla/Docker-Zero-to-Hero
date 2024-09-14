FROM ubuntu:latest
WORKDIR /apps
COPY . /apps
RUN apt-get update && apt-get install -y nodejs npm
CMD ["node","app.js"]
