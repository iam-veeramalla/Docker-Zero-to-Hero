# Interview Question and Answers on Docker

##### Question 1 - What is Docker?
##### Answer 1 - 
- Docker is an opensource containerization platform. It enables developers to package applications into containers.

##### Question 2 - How Containers are different from Virtual Machines?
##### Answer 2 - 
- Containers are very lightweight in nature because they don't have complete OS. Whereas once you install hypervisor on top of which you have virtual machine which has a complete guest Operating System.

Containers is bascially a combination of application dependencies and some system librabries.

##### Question 3 - What is Docker Lifecycle?
##### Answer 3 - 
- Users would create a Docker file with set of instructiions or commands that defines a docker image. For exapmle, which base image to choose?
what dependencies should be installed for the application to run? etc..

- Docker image act as a set of instructions to buid a Docker Container. It can be compared to a snapshot in a VM.

##### Question 4 - What are different Docker Components?
##### Answer 4 - 
- In docker there are components like Docker client which is called as CLI. Docker host or Docker daemon which is called as a heart of docker (it responsible for receiving your actions). Docker registry which is a repository of docker images.

##### Question 5 - What is the difference between docker COPY and docker ADD?
##### Answer 5 - 
- Docker ADD can copy the files from a URL unlike Docker COPY which can only copy files from host system into the container.

##### Question 6 - What is the difference between CMD and ENTRYPOINT in Dockerfile?
##### Answer 6 - 
- CLI arguments using the Docker run command will override the arguments specified using the CMD instruction.

- Wheras ENTRYPOINT instruction in the shell from will override additional arguments provide using CLI parameters or even through the CMD commands.

##### Question 7 - What is the types in Docker and What is the default Network?
##### Answer 7 - 
- Default network type is Bridge Network.
           However, you can changes the default and configure one of the 
           1. Bridge Network
           2. Overlay Network
           3. Host Network
           4. MacVlan Network

##### Question 8 - Can you explain how to isolate the networking between containers?
##### Answer 8 - 
- You can use the network namespace to isolate the networking between containers. You can also use the --net option to specify the network namespace to be used by the container. For obtaining isolations of network you can create own networks.

##### Question 9 - What is a multi-stage build in network?
##### Answer 9 - 
- Multi-stage build allows you to build your docker container in multiple stages allowing you to copy artifacts from one stage to another. The major advantage of multi-stage builds is to build a light weight container.

##### Question 10 - What are distroless image in Docker?
##### Answer 10 - 
- Distroless images contain your application and its runtime dependencies with a very minimum operating system libraries. They do not contain package managers, shells or any other programs you would expect to find a standard Linux distribution. They are very small and lightweight images.

##### Question 11 - What are Real time Challenges in Docker?
##### Anwer 11 - 
- Docker is a single daemon process. Which can cause a single point of failure, if the docker daemon goes down for some reason then all the application on containers are down.

- Dcoker daemon runs as a root user. Which is a security threat. Any process running as a root can have adverse effects. When it is compromised for a security reasons, it can impact other applications or containers on the host.

- Resource contraints: If you are running too many containers on a single host, you may experience issues with resource constraints. This can result in slow performance or crashes. 

##### Question 12 -What steps would you take to secure containers?
##### Answer 12 - Some of the steps are:

- Use distroless or images with not too many packages as your final image in multi-stage build, so that there is less chance of CVE or security issues.

- Ensure that the networking is configured properly. This is one of the most common reasons for security issues. If required configure bridge networks and assign them to isolate containers.

- Use utilities like sync to scan your container images.

##### Question 13. How will you run multiple Docker containers in one single host?
##### Answer: 
- Docker Compose is the best way to run multiple containers as a single service by defining them in a docker-compose.yml file.

##### Question 14. If you delete a running container, what happens to the data stored in that container?
##### Answer: 
- When a running container is deleted, all data in its file system also goes away. However, we can use Docker Data Volumes to persist data even if the container is deleted.

##### Question 15. How do you manage sensitive security data like passwords in Docker?
##### Answer: 
- Docker Secrets and Docker Environment Variables can be used to manage sensitive data.

##### Question 16. What is the difference between Docker Image and a Docker Container?
##### Answer: 
- Docker Image is a template that contains the application, libraries, and dependencies required to run an application, whereas a Docker Container is the running instance of a Docker Image.

##### Question 17. How do you handle persistent storage in Docker?
##### Answer: 
- Docker Volumes and Docker Bind Mounts are used to handle persistent storage in Docker.

##### Question 18. What is the process to create a Docker Container from a Dockerfile?
##### Answer: 
- Docker Build command is used to create Docker images from a Dockerfile and then Docker Run command is used to create Containers from Docker images.

##### Question 19. How will you scale Docker containers based on traffic to your application?
##### Answer: 
- Docker Swarm or Kubernetes can be used to auto-scale Docker Containers based on traffic load.

##### Question 20. When RUN and CMD instructions will be executed?
##### Answer: 
- RUN instruction will be executed while building the Docker Image. CMD instruction will be executed while starting the Container.

##### Question 21. What’s the different between COPY and ADD instructions?
##### Answer: 
- Using COPY instruction,We can copy local files and folders from docker build context to Docker Image. These files and folders will be copied while creating a Docker Image.
- ADD instruction works similar to COPY instruction but the only different is that we can download files from remote locations that’s from Internet while creating a Docker Image.

##### Question 22. What’s the different between CMD and ENTRYPOINT instructions?
##### Answer: 
- CMD instruction will be used to start the process or application inside the Container.
- ENTRYPOINT instruction also works similar to CMD instruction. ENTRYPOINT instruction will also be executed while creating a container. CMD instruction can be overridden while creating a Container where as ENTRYPOINT instruction cannot be overridden while creating a Container.

##### Question 23. When we have both CMD and ENTRYPOINT instructions in a Dockerfile?
##### Answer: 
- CMD instruction will not be executed and CMD instruction will be passed as an argument for ENTRYPOINT.
