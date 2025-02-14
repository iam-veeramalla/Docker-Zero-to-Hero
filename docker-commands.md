# Docker Commands

Docker is a platform for developing, shipping, and running applications in containers. Below are commonly used Docker commands categorized for better understanding.

## 1. Docker Images

### List Images
```sh
docker images
```
Lists all Docker images available on the host machine.

### Build an Image
```sh
docker build -t <image_name> .
```
Builds an image from a `Dockerfile` in the current directory and tags it with `<image_name>`.

### Remove an Image
```sh
docker rmi <image_id>
```
Deletes a specific Docker image from the host machine.

### Pull an Image from a Registry
```sh
docker pull <image_name>
```
Downloads an image from a Docker registry (e.g., Docker Hub).

### Push an Image to a Registry
```sh
docker push <image_name>
```
Uploads an image to a configured Docker registry.

## 2. Docker Containers

### Run a Container
```sh
docker run <image_name>
```
Runs a container from the specified image.

#### Common Flags for `docker run`:
- `-d` → Run container in the background and print container ID.
- `-p <host_port>:<container_port>` → Map host port to container port.
- `-e "VAR=value"` → Set environment variables.
- `--name <container_name>` → Assign a name to the container.
- `--rm` → Remove container after it stops.
- `-v <host_path>:<container_path>` → Mount a volume.
- `--network <network_name>` → Connect the container to a specific network.

**Understanding Commands with Flags**
Docker commands can include flags (options) that modify their behavior. For example:
```sh
docker run -d -p 8080:80 --name mycontainer nginx
```
- `-d` runs the container in detached mode.
- `-p 8080:80` maps port 8080 on the host to port 80 in the container.
- `--name mycontainer` assigns the name "mycontainer" to the container.
- `nginx` specifies the image to use.

### List Running Containers
```sh
docker ps
```
Shows running containers.

### List All Containers (Including Stopped)
```sh
docker ps -a
```
Displays all containers, whether running or stopped.

### Stop a Running Container
```sh
docker stop <container_id>
```
Stops a specific running container.

### Start a Stopped Container
```sh
docker start <container_id>
```
Starts a previously stopped container.

### Restart a Container
```sh
docker restart <container_id>
```
Restarts a container.

### Remove a Container
```sh
docker rm <container_id>
```
Deletes a stopped container.

### Execute a Command in a Running Container
```sh
docker exec -it <container_id> <command>
```
Runs a command inside an active container. For example:
```sh
docker exec -it <container_id> bash
```
Starts an interactive shell inside the container.

### Attach to a Running Container
```sh
docker attach <container_id>
```
Attach to a running container's standard input, output, and error streams.

## 3. Docker Volumes

### List Volumes
```sh
docker volume ls
```
Shows all Docker volumes.

### Create a Volume
```sh
docker volume create <volume_name>
```
Creates a new Docker volume.

### Remove a Volume
```sh
docker volume rm <volume_name>
```
Deletes a specific Docker volume.

## 4. Docker Networks

### List Networks
```sh
docker network ls
```
Shows all available networks.

### Create a Network
```sh
docker network create <network_name>
```
Creates a custom network.

### Connect a Container to a Network
```sh
docker network connect <network_name> <container_name>
```
Adds a container to a specific network.

### Disconnect a Container from a Network
```sh
docker network disconnect <network_name> <container_name>
```
Removes a container from a network.

### Remove a Network
```sh
docker network rm <network_name>
```
Deletes a specific network.

## 5. Docker Logs and Monitoring

### View Logs of a Container
```sh
docker logs <container_id>
```
Displays logs from a running container.

### Follow Container Logs in Real-Time
```sh
docker logs -f <container_id>
```
Continuously streams logs from the container.

### Show Container Resource Usage
```sh
docker stats
```
Displays CPU, memory, and network usage of running containers.

### Inspect a Container
```sh
docker inspect <container_id>
```
Displays detailed information about a specific container.

## 6. Docker Compose (Multi-Container Applications)

### Start Services in the Background
```sh
docker-compose up -d
```
Starts all services defined in a `docker-compose.yml` file.

### Stop Services
```sh
docker-compose down
```
Stops and removes containers defined in the `docker-compose.yml` file.

### Restart Services
```sh
docker-compose restart
```
Restarts all services.

## 7. Build vs Buildx

### `docker build`
The `docker build` command builds an image from a `Dockerfile`. It is the default build command and is primarily used for local development and single-platform builds.
```sh
docker build -t myimage .
```

### `docker buildx`
The `docker buildx` command is an advanced build tool that extends `docker build`. It enables multi-platform builds, caching, and better performance. It is recommended for complex builds and CI/CD workflows.
```sh
docker buildx build --platform linux/amd64,linux/arm64 -t myimage .
```
- Supports multiple architectures.
- Uses advanced caching mechanisms.
- Ideal for cross-platform image building.

## Conclusion

These Docker commands cover essential operations for managing images, containers, volumes, networks, and logs. Docker simplifies the process of building, running, and managing containerized applications efficiently.

For further details, run:
```sh
docker --help
```
This provides additional command options and usage details.

