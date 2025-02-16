# Docker Networking and Basic Commands

## What is Detach Mode in Docker?

Detach mode in Docker (`-d` flag) allows containers to run in the background without attaching to the terminal session. This means the container continues running even after the terminal session is closed.

Example:

```sh
docker run -d --name my_container nginx:latest
```

This runs an Nginx container in the background.

## What is Nginx and Its Use?

Nginx is a high-performance web server, reverse proxy, and load balancer. It is commonly used to serve static files, proxy requests to backend services, and manage high-traffic websites.

---

## Docker Basic Commands Explanation

### 1. `docker ps -a`

Lists all running and stopped containers.

```sh
docker ps -a
```

### 2. `docker images`

Lists all available images on the system.

```sh
docker images
```

### 3. `docker stop <container_name>`

Gracefully stops a running container.

```sh
docker stop my_container
```

### 4. `docker kill <container_name>`

Immediately stops a container forcefully.

```sh
docker kill my_container
```

### 5. `docker rm -f <container_name>`

Removes a container forcefully.

```sh
docker rm -f my_container
```

---

## Docker Networking

Docker provides various networking modes. Below are the key ones:

### 1. Bridge Networking (Default)

Bridge networking allows containers to communicate within the same bridge network but isolates them from external networks unless explicitly linked.

#### Example: Creating Three Containers (`login`, `logout`, and `finance`)

```sh
docker run -d --name login nginx:latest
```

Since `docker run` first looks for the image locally, if `nginx:latest` is not found, it pulls it from Docker Hub.

#### Logging into the `login` container:

```sh
docker exec -it login /bin/bash
```

#### Installing `ping` inside the container:

```sh
apt update
apt-get install iputils-ping -y
```

`ping` is a command-line tool used to test network connectivity between hosts.

#### Logout from the container:

```sh
exit
```

#### Creating another container `logout`:

```sh
docker run -d --name logout nginx:latest
```

#### Checking running containers:

```sh
docker ps
```

#### Inspecting containers:

```sh
docker inspect login
```

```sh
docker inspect logout
```

This displays details like network settings, including subnet and IPs (e.g., `172.17.0.2` and `172.17.0.3`).

#### Verifying communication between `login` and `logout`:

```sh
docker exec -it login /bin/bash
ping 172.17.0.3
```

This confirms that `login` and `logout` can communicate within the default bridge network.

### 2. Isolating `finance` Container Using a Custom Bridge Network

In this section, we create a custom bridge network to isolate the `finance` container from the default bridge network. Containers in this network will have their own subnet, separate from the default bridge network.

#### Create a custom network:

```sh
docker network create secure-network
```

#### Verify network creation:

```sh
docker network ls
```

#### Run `finance` container on the `secure-network`:

```sh
docker run -d --name finance --network=secure-network nginx:latest
```

#### Inspect `finance` container:

```sh
docker inspect finance
```

Here, the `finance` container gets an IP different from the default bridge network.

#### Verify communication restriction:

```sh
docker exec -it login /bin/bash
ping 172.19.0.2  # (IP might differ based on network assignment)
```

This will fail since `finance` is on an isolated network.

### 3. Host Networking Mode

Host networking allows a container to share the host machine's network stack, eliminating the need for a private IP.

#### Run container using host network:

```sh
docker run -d --name host-demo --network=host nginx:latest
```

#### Inspect container:

```sh
docker inspect host-demo
```

Here, you will notice that the container does not have a separate IP because it shares the host’s network.

---

## Managing Docker Networks

### List all networks:

```sh
docker network ls
```

### Remove a network:

```sh
docker network rm <network_name>
```

Example:

```sh
docker network rm secure-network
```

---

## Summary

- **Detach mode -d runs containers in the background.
- **Nginx** is a web server and reverse proxy.
- **Basic commands** like `docker ps`, `docker images`, `docker stop`, and `docker rm` manage containers.
- **Bridge networking** allows communication within the same bridge but isolates from external networks.
- **Custom bridge networks** isolate certain containers (`finance` container example).
- **Host networking** binds the container directly to the host’s network.
- **Docker networks** can be listed, inspected, and removed when needed.

This guide provides a hands-on understanding of Docker networking and essential commands.

