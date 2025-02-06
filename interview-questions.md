
**1) What is Docker?**

Docker is an open-source containerization platform. It enables developers to package applications into containers.

**2) How are containers different from virtual machines?**

Containers are very light in nature because they don't have a complete OS.

Containers are combinations of `application dependency` and `system library`.

**3) Docker Lifecycle?**

A user would create a Dockerfile with a set of instructions or commands that define a Docker image. e.g., which base image should I choose? what dependencies should be installed for the application to run.

Docker changes act as a set of instructors to build a Docker container. It can be compared to a snapshot in a VM.

**4) What are the different Docker Components ?**

When you install Docker, you have the `client`. Client is the Docker cli.

Using the client, while installing Docker, we install something called `docker deamon` or `docker host`.

Which is responsible for executing the tasks. Daemon is the most important of the components.

We have a Docker registry to store Docker images.

![Docker components](https://imgur.com/7w2j0j4.png)

**5) What is the difference between docker copy and docker add?**

**docker ADD** -> Docker ADD can copy or download the files from a URL.

**docker COPY** -> Docker COPY, which can only copy files from the host system into the container.

**6) What is the difference between CMD"  and Entrypoint in Docker?**

**CMD** -> CLI arguments using the Docker run command will override the arguments specified using the CMD instructions.

**Entrypoint** -> Whereas ENTRYPOINT instructions in the shell form will override additional arguments provided using CLI parameters or even through the CMD commands.

**7) What are the networking types in Docker, and what is the default?**

The default network is Bridge.

You can change the default type and configure one of them.

  1. **Bridge** -> veth0/docker0 network is created using that docker connect with the host. You can create custom bridge network to isolate containers.

  2. **Overlay**: This mode enables communication between containers across multiple Docker host machines, allowing containers to be connected to a single network even when they are running on different hosts.


  3. **Host**: Bind the host network with the container network.

  4. **MacVlan**: This mode allows a container to appear on the network as a physical host rather than as a container.

**8) Can you explain how to isolate networking between the containers?**

You can create your own bridge network using ```docker network create newNetwork```, and then you can build the container with the new network using ```docker run --name d1 --network=newNetwork image```.


**9) What is a multi-stage build in Docker?**

Muilti stage build allows you to build your Docker container in multiple stages, allowing you to copy artefacts from one stage to another.

The major advantage of this is that it builds light-weight continer.

**10) What are distro-less images in Docker?**

Distroless images contain only your application and its runtime dependencies, with a very minimum of OS libraries.

They do not contain package managers, shells, or any other programmes you would expect to find in a standard Linux distribution.

They are very small and light-weight images.

**11) Real-Time Challenges with Docker?**

      1. Docker is a single daemon process. Which is a single point of failure.
      2. The Docker daemon runs as a root user. Which is a security threat. Podman is one such thing that does not have a single point of failure.
      3. **Resource Constraints**.

**12)  What steps would you take to secure the contents?**

     1. Use Distroless or Imags with not too many packages as your final image in a multi-stage build so that there is less chance of CVE or security issues.
     2. Ensure that the networking is configured properly. This is one of the most common reasons for security issues.
     3. Use utilities like SYNC to scan your container images.
