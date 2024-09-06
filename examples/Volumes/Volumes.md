# Docker Volume
- A Docker volume is a persistent storage mechanism that allows data to be shared and reused among Docker containers, as well as persisted across container restarts and removals.

```bash
FROM ubuntu
VOLUME ["/my-volume"]
```
- To create a image from Dockerfile
```bash
docker build -t my-image .
```
- Create a container from image
```bash
docker run -it --name container1 my-image /bin/bash
```
- Now share volume with another container
```bash
docker run -it --name container2 --privileged=true --value-from container1  image1 /bin/bash
```

### Now try to create a volume by using command

```bash
docker run -it --name container3 -v/volume2 image3 /bin/bash
```
``` bash
Do, ls
o/p volume2
cd volume2
Now create a one file textfile and exit
```
### Now create one more container and share volume2
```bash
docker run -it --name container4 --privileged=true --value-from container3 image4 /bin/bash
```
 Now inside the container do ls, you can see volume2.

## Docker Volumes: Host-Container Binding
 In the context of Docker volumes, "host-container" binding refers to mapping a directory from the host machine (the physical or virtual machine where Docker is running) to a directory inside a Docker container. This setup allows the container to access and use files from the host system, and any changes made to the files in the container are reflected on the host.
### Key Points
- `Host Directory`: The directory on the host machine that you want to share with the container.
- `Container Directory`: The directory inside the container where the host directory will be mounted.
- `Persistence`: Data stored in the host directory persists independently of the container's lifecycle.
- `Data Sharing`: Enables easy sharing of data between the host and the container, and among multiple containers if needed.

```bash
# Verfiy the files using pwd eg: soma2000@ASUS:/mnt/e/Devops/Devops/Docker-Zero-to-Hero/examples/Volumes$

docker run -it --name hostcontainer -v/soma2000@ASUS:/mnt/e/Devops/Devops/Docker-Zero-to-Hero/examples/Volumes:/container2 --privileged=true image_name /bin/bash
```
 - Do ls, now you can see all files of host machine.
 - If create a file in the container we will see this file in host machine.
 