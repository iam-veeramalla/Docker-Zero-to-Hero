# Docker Commands

Some of the most commonly used docker commands are 

### docker images

Lists docker images on the host machine.

### docker build

Builds image from Dockerfile.

### docker run

Runs a Docker container. 

There are many arguments which you can pass to this command for example,

`docker run -d` -> Run container in background and print container ID
`docker run -p` -> Port mapping

use `docker run --help` to look into more arguments.

### docker ps

Lists running containers on the host machine.

### docker stop

Stops running container.

### docker start

Starts a stopped container.

### docker rm

Removes a stopped container.

### docker rmi

Removes an image from the host machine.

### docker pull

Downloads an image from the configured registry.

### docker push

Uploads an image to the configured registry.

### docker exec

Run a command in a running container.

### docker inspect <container_name/container_id>

To inspect the conatiner

### docker network

Manage Docker networks such as creating and removing networks, and connecting containers to networks.

### docker volume ls

It displays all running volumes

### docker volume create <volume-name>

It is used to create a volume

### docker volume inspect <volume-name>

It is used to inspect the given volume i.e inspecting whether it is local or remote volume / where it is created

### docker volume rm <volume-name1> <volume-name2>

Deletes the given volumes

