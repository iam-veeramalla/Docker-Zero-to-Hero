# Repo to learn Docker with examples. Contributions are most welcome.

## If you found this repo useful, give it a STAR 🌠




## What is a container ?

A container is a standard unit of software that packages up code and all its dependencies so the application runs quickly and reliably from one computing environment to another. A Docker container image is a lightweight, standalone, executable package of software that includes everything needed to run an application: code, runtime, system tools, system libraries and settings.

Ok, let me make it easy !!!

A container is a bundle of Application, Application libraries required to run your application and the minimum system dependencies.

![Screenshot 2023-02-07 at 7 18 10 PM](https://user-images.githubusercontent.com/43399466/217262726-7cabcb5b-074d-45cc-950e-84f7119e7162.png)



## Containers vs Virtual Machine

Containers and virtual machines are both technologies used to isolate applications and their dependencies, but they have some key differences:

    1. Resource Utilization: Containers share the host operating system kernel, making them lighter and faster than VMs. VMs have a full-fledged OS and hypervisor, making them more resource-intensive.

    2. Portability: Containers are designed to be portable and can run on any system with a compatible host operating system. VMs are less portable as they need a compatible hypervisor to run.

    3. Security: VMs provide a higher level of security as each VM has its own operating system and can be isolated from the host and other VMs. Containers provide less isolation, as they share the host operating system.

   4.  Management: Managing containers is typically easier than managing VMs, as containers are designed to be lightweight and fast-moving.



## Why are containers light weight ?

Containers are lightweight because they use a technology called containerization, which allows them to share the host operating system's kernel and libraries, while still providing isolation for the application and its dependencies. This results in a smaller footprint compared to traditional virtual machines, as the containers do not need to include a full operating system. Additionally, Docker containers are designed to be minimal, only including what is necessary for the application to run, further reducing their size.

Let's try to understand this with an example:

Below is the screenshot of official ubuntu base image which you can use for your container. It's just ~ 22 MB, isn't it very small ? on a contrary if you look at official ubuntu VM image it will be close to ~ 2.3 GB. So the container base image is almost 100 times less than VM image.

![Screenshot 2023-02-08 at 3 12 38 PM](https://user-images.githubusercontent.com/43399466/217493284-85411ae0-b283-4475-9729-6b082e35fc7d.png)


To provide a better picture of files and folders that containers base images have and files and folders that containers use from host operating system (not 100 percent accurate -> varies from base image to base image). Refer below.



### Files and Folders in containers base images

```
    /bin: contains binary executable files, such as the ls, cp, and ps commands.

    /sbin: contains system binary executable files, such as the init and shutdown commands.

    /etc: contains configuration files for various system services.

    /lib: contains library files that are used by the binary executables.

    /usr: contains user-related files and utilities, such as applications, libraries, and documentation.

    /var: contains variable data, such as log files, spool files, and temporary files.

    /root: is the home directory of the root user.
```



### Files and Folders that containers use from host operating system

```
    The host's file system: Docker containers can access the host file system using bind mounts, which allow the container to read and write files in the host file system.

    Networking stack: The host's networking stack is used to provide network connectivity to the container. Docker containers can be connected to the host's network directly or through a virtual network.

    System calls: The host's kernel handles system calls from the container, which is how the container accesses the host's resources, such as CPU, memory, and I/O.

    Namespaces: Docker containers use Linux namespaces to create isolated environments for the container's processes. Namespaces provide isolation for resources such as the file system, process ID, and network.

    Control groups (cgroups): Docker containers use cgroups to limit and control the amount of resources, such as CPU, memory, and I/O, that a container can access.
    
```

It's important to note that while a container uses resources from the host operating system, it is still isolated from the host and other containers, so changes to the container do not affect the host or other containers.

**Note:** There are multiple ways to reduce your VM image size as well, but I am just talking about the default for easy comparision and understanding.

so, in a nutshell, container base images are typically smaller compared to VM images because they are designed to be minimalist and only contain the necessary components for running a specific application or service. VMs, on the other hand, emulate an entire operating system, including all its libraries, utilities, and system files, resulting in a much larger size. 

I hope it is now very clear why containers are light weight in nature.



## Docker


### What is Docker ?

Docker is a containerization platform that provides easy way to containerize your applications, which means, using Docker you can build container images, run the images to create containers and also push these containers to container regestries such as DockerHub, Quay.io and so on.

In simple words, you can understand as `containerization is a concept or technology` and `Docker Implements Containerization`.


### Docker Architecture ?

![image](https://user-images.githubusercontent.com/43399466/217507877-212d3a60-143a-4a1d-ab79-4bb615cb4622.png)

The above picture, clearly indicates that Docker Deamon is brain of Docker. If Docker Deamon is killed, stops working for some reasons, Docker is brain dead :p (sarcasm intended).

### Docker LifeCycle 

We can use the above Image as reference to understand the lifecycle of Docker.

There are three important things,

1. docker build -> builds docker images from Dockerfile
2. docker run   -> runs container from docker images
3. docker push  -> push the container image to public/private regestries to share the docker images.

![Screenshot 2023-02-08 at 4 32 13 PM](https://user-images.githubusercontent.com/43399466/217511949-81f897b2-70ee-41d1-b229-38d0572c54c7.png)



### Understanding the terminology (Inspired from Docker Docs)


#### Docker daemon

The Docker daemon (dockerd) listens for Docker API requests and manages Docker objects such as images, containers, networks, and volumes. A daemon can also communicate with other daemons to manage Docker services.


#### Docker client

The Docker client (docker) is the primary way that many Docker users interact with Docker. When you use commands such as docker run, the client sends these commands to dockerd, which carries them out. The docker command uses the Docker API. The Docker client can communicate with more than one daemon.


#### Docker Desktop

Docker Desktop is an easy-to-install application for your Mac, Windows or Linux environment that enables you to build and share containerized applications and microservices. Docker Desktop includes the Docker daemon (dockerd), the Docker client (docker), Docker Compose, Docker Content Trust, Kubernetes, and Credential Helper. For more information, see Docker Desktop.


#### Docker registries

A Docker registry stores Docker images. Docker Hub is a public registry that anyone can use, and Docker is configured to look for images on Docker Hub by default. You can even run your own private registry.

When you use the docker pull or docker run commands, the required images are pulled from your configured registry. When you use the docker push command, your image is pushed to your configured registry.
Docker objects

When you use Docker, you are creating and using images, containers, networks, volumes, plugins, and other objects. This section is a brief overview of some of those objects.


#### Dockerfile

Dockerfile is a file where you provide the steps to build your Docker Image. 


#### Images

An image is a read-only template with instructions for creating a Docker container. Often, an image is based on another image, with some additional customization. For example, you may build an image which is based on the ubuntu image, but installs the Apache web server and your application, as well as the configuration details needed to make your application run.

You might create your own images or you might only use those created by others and published in a registry. To build your own image, you create a Dockerfile with a simple syntax for defining the steps needed to create the image and run it. Each instruction in a Dockerfile creates a layer in the image. When you change the Dockerfile and rebuild the image, only those layers which have changed are rebuilt. This is part of what makes images so lightweight, small, and fast, when compared to other virtualization technologies.



## INSTALL DOCKER

A very detailed instructions to install Docker are provide in the below link

https://docs.docker.com/get-docker/

For Demo, 

You can create an Ubuntu EC2 Instance on AWS and run the below commands to install docker.

```
sudo apt update
sudo apt install docker.io -y
```


### Start Docker and Grant Access

A very common mistake that many beginners do is, After they install docker using the sudo access, they miss the step to Start the Docker daemon and grant acess to the user they want to use to interact with docker and run docker commands.

Always ensure the docker daemon is up and running.

A easy way to verify your Docker installation is by running the below command

```
docker run hello-world
```

If the output says:

```
docker: Got permission denied while trying to connect to the Docker daemon socket at unix:///var/run/docker.sock: Post "http://%2Fvar%2Frun%2Fdocker.sock/v1.24/containers/create": dial unix /var/run/docker.sock: connect: permission denied.
See 'docker run --help'.
```

This can mean two things, 
1. Docker deamon is not running.
2. Your user does not have access to run docker commands.


### Start Docker daemon

You use the below command to verify if the docker daemon is actually started and Active

```
sudo systemctl status docker
```

If you notice that the docker daemon is not running, you can start the daemon using the below command

```
sudo systemctl start docker
```


### Grant Access to your user to run docker commands

To grant access to your user to run the docker command, you should add the user to the Docker Linux group. Docker group is create by default when docker is installed.

```
sudo usermod -aG docker ubuntu
```

In the above command `ubuntu` is the name of the user, you can change the username appropriately.

**NOTE:** : You need to logout and login back for the changes to be reflected.


### Docker is Installed, up and running 🥳🥳

Use the same command again, to verify that docker is up and running.

```
docker run hello-world
```

Output should look like:

```
....
....
Hello from Docker!
This message shows that your installation appears to be working correctly.
...
...
```


## Great Job, Now start with the examples folder to write your first Dockerfile and move to the next examples. Happy Learning :)

### Clone this repository and move to example folder

```
git clone https://github.com/iam-veeramalla/Docker-Zero-to-Hero
cd  examples
```

### Login to Docker [Create an account with https://hub.docker.com/]

```
docker login
```

```
Login with your Docker ID to push and pull images from Docker Hub. If you don't have a Docker ID, head over to https://hub.docker.com to create one.
Username: abhishekf5
Password:
WARNING! Your password will be stored unencrypted in /home/ubuntu/.docker/config.json.
Configure a credential helper to remove this warning. See
https://docs.docker.com/engine/reference/commandline/login/#credentials-store

Login Succeeded
```

### Build your first Docker Image

You need to change the username accoringly in the below command

```
docker build -t abhishekf5/my-first-docker-image:latest .
```

Output of the above command

```
    Sending build context to Docker daemon  992.8kB
    Step 1/6 : FROM ubuntu:latest
    latest: Pulling from library/ubuntu
    677076032cca: Pull complete
    Digest: sha256:9a0bdde4188b896a372804be2384015e90e3f84906b750c1a53539b585fbbe7f
    Status: Downloaded newer image for ubuntu:latest
     ---> 58db3edaf2be
    Step 2/6 : WORKDIR /app
     ---> Running in 630f5e4db7d3
    Removing intermediate container 630f5e4db7d3
     ---> 6b1d9f654263
    Step 3/6 : COPY . /app
     ---> 984edffabc23
    Step 4/6 : RUN apt-get update && apt-get install -y python3 python3-pip
     ---> Running in a558acdc9b03
    Step 5/6 : ENV NAME World
     ---> Running in 733207001f2e
    Removing intermediate container 733207001f2e
     ---> 94128cf6be21
    Step 6/6 : CMD ["python3", "app.py"]
     ---> Running in 5d60ad3a59ff
    Removing intermediate container 5d60ad3a59ff
     ---> 960d37536dcd
    Successfully built 960d37536dcd
    Successfully tagged abhishekf5/my-first-docker-image:latest
```

### Verify Docker Image is created

```
docker images
```

Output 

```
REPOSITORY                         TAG       IMAGE ID       CREATED          SIZE
abhishekf5/my-first-docker-image   latest    960d37536dcd   26 seconds ago   467MB
ubuntu                             latest    58db3edaf2be   13 days ago      77.8MB
hello-world                        latest    feb5d9fea6a5   16 months ago    13.3kB
```

### Run your First Docker Container

```
docker run -it soma1999/my-first-docker-image
```

Output

```
Hello World
```

### Push the Image to DockerHub and share it with the world

```
docker push soma1999/my-first-docker-image
```

Output

```
Using default tag: latest
The push refers to repository [docker.io/abhishekf5/my-first-docker-image]
896818320e80: Pushed
b8088c305a52: Pushed
69dd4ccec1a0: Pushed
c5ff2d88f679: Mounted from library/ubuntu
latest: digest: sha256:6e49841ad9e720a7baedcd41f9b666fcd7b583151d0763fe78101bb8221b1d88 size: 1157
```

### You must be feeling like a champ already 

# -----------------------------------------------------------------------------------------------------------------------------------------
# Important Docker Interview Questions

## Docker Interview

Docker is a crucial topic for DevOps Engineer interviews, especially for freshers. Here are some essential questions to help you prepare and ace your Docker interviews:

## Questions

- **What is the difference between an Image, Container, and Engine?**
  - **Image**: A lightweight, standalone, and executable software package that includes everything needed to run a piece of software, including the code, runtime, libraries, and environment variables.
  - **Container**: A running instance of a Docker image. It is a lightweight, standalone environment that runs the application and its dependencies.
  - **Engine**: The core component of Docker that allows you to build and run containers. It manages the containers, images, networks, and storage.

- **What is the difference between the Docker command COPY vs ADD?**
  - **COPY**: Used to copy files and directories from the host file system to the Docker image. It is a straightforward command that does not unpack compressed files.
  - **ADD**: Similar to COPY, but it can also unpack compressed files (like .tar.gz) and can pull files from remote URLs. However, it is generally recommended to use COPY for local files to avoid unintended behaviors.

- **What is the difference between the Docker command CMD vs RUN?**
  - **CMD**: Specifies the default command to run when a container is started. It can be overridden by command line arguments.
  - **RUN**: Used to execute commands during the image build process. It creates a new layer in the image for each command executed.

- **How will you reduce the size of a Docker image?**
  - Use smaller base images.
  - Combine multiple RUN commands into a single command to minimize layers.
  - Remove unnecessary files and dependencies in the image.
  - Use `.dockerignore` to exclude files not needed in the image.

- **Why and when should you use Docker?**
  - Use Docker to simplify the development, deployment, and scaling of applications. It helps create consistent environments across different stages (development, testing, production).

- **Explain the Docker components and how they interact with each other.**
  - **Docker Daemon**: Runs on the host and manages Docker containers.
  - **Docker Client**: The command-line interface for interacting with the Docker daemon.
  - **Docker Hub**: A public registry for sharing Docker images.
  - **Docker Compose**: A tool for defining and running multi-container Docker applications.

- **Explain the terminology: Docker Compose, Dockerfile, Docker Image, Docker Container.**
  - **Docker Compose**: A tool for defining and managing multi-container Docker applications using a `docker-compose.yml` file.
  - **Dockerfile**: A text file that contains instructions on how to build a Docker image.
  - **Docker Image**: A snapshot of a filesystem that contains everything needed to run an application.
  - **Docker Container**: A running instance of a Docker image, isolated from other containers.

- **In what real scenarios have you used Docker?**
  - Describe specific projects or use cases where Docker was instrumental in development, testing, or production environments.

- **Docker vs Hypervisor?**
  - Docker containers share the host OS kernel and are lightweight compared to hypervisors, which create separate virtual machines with their own OS.

- **What are the advantages and disadvantages of using Docker?**
  - **Advantages**: Consistency across environments, efficient resource utilization, fast deployment, and isolation.
  - **Disadvantages**: Security concerns, complexity in managing containers, and potential for performance overhead.

- **What is a Docker namespace?**
  - Namespaces provide isolation between containers, allowing them to run independently with their own resources.

- **What is a Docker registry?**
  - A storage and distribution system for Docker images. Docker Hub is the default public registry.

- **What is an entry point?**
  - An entry point is a command that is always executed when a container starts, similar to CMD but more rigid.

- **How to implement CI/CD in Docker?**
  - Use Docker images in your CI/CD pipeline to create consistent environments for testing and deployment.

- **Will data on the container be lost when the Docker container exits?**
  - Yes, data stored in a container is ephemeral. Use volumes to persist data.

- **What is a Docker swarm?**
  - A clustering and orchestration tool for managing multiple Docker hosts as a single virtual host.

- **What are the Docker commands for the following:**
  - **Viewing running containers**: `docker ps`
  - **Running a container under a specific name**: `docker run --name <container_name> <image_name>`
  - **Exporting a Docker image**: `docker save -o <file_name>.tar <image_name>`
  - **Importing an existing Docker image**: `docker load -i <file_name>.tar`
  - **Deleting a container**: `docker rm <container_id>`
  - **Removing all stopped containers, unused networks, build caches, and dangling images**: `docker system prune`

- **What are the common Docker practices to reduce the size of Docker images?**
  - Use multi-stage builds, keep layers minimal, and regularly clean up unused images and containers.

- **How do you troubleshoot a Docker container that is not starting?**
  - Check the container logs using `docker logs <container_id>` and inspect the container’s configuration with `docker inspect <container_id>`.

- **Can you explain the Docker networking model?**
  - Docker provides different network types: bridge, host, overlay, and none, to facilitate communication between containers.

- **How do you manage persistent storage in Docker?**
  - Use Docker volumes to store data outside of the container filesystem, allowing data to persist even if the container is removed.

- **How do you secure a Docker container?**
  - Implement the principle of least privilege, use trusted images, keep containers updated, and restrict network access.

- **What is Docker overlay networking?**
  - A method to connect multiple Docker daemons and their containers, allowing them to communicate as if they were on the same network.

- **How do you handle environment variables in Docker?**
  - Pass environment variables using the `-e` flag in `docker run` or define them in a `docker-compose.yml` file under the `environment` section.

These questions will help you in your next DevOps interview. Write a blog and share it on LinkedIn to showcase your knowledge.



