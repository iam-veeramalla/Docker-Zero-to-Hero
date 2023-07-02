# Docker Bind Mount & VOLUME Commands
### Docker Bind Mount Commands
In Docker, you can use various commands to create and manage bind mounts. Here are some commonly used commands related to bind mounts:

docker run: You can use the -v or --volume option with the docker run command to create a bind mount during container creation.
```
docker run -v <host-path>:<container-path> ...
```
For example, to bind mount the /data directory on the host to the /app/data directory inside the container:
```
docker run -v /data:/app/data ...
```
docker create: Similar to docker run, you can use the -v or --volume option with the docker create command to create a container without starting it.
```
docker create -v <host-path>:<container-path> ...
```
For example:
```
docker create -v /data:/app/data ...
```
docker volume create: You can use the docker volume create command to create a named volume that can be later used for bind mounting.
```
docker volume create <volume-name>
```
For example:
```
docker volume create mydata
```
docker run with a named volume: You can use a named volume in place of the <host-path> when creating a bind mount.
```
docker run -v <volume-name>:<container-path> ...
```
For example, to use the named volume mydata instead of a specific host path:
```
docker run -v mydata:/app/data ...
```
docker inspect: You can use the docker inspect command to view detailed information about a container, including its mount points.
```
docker inspect <container-id or container-name>
```
For example:
```
docker inspect mycontainer
```
These are some of the key commands related to bind mounts in Docker. Bind mounts provide flexibility in managing data and sharing files between the host machine and containers, allowing seamless interaction between the two.

### Docker Volume Commands

In Docker, you can use various commands to manage volumes. Volumes are a way to persist and manage data associated with Docker containers. Here are some commonly used Docker volume commands:

1.  **docker volume create**: This command is used to create a named volume.
    
    
    ```
    docker volume create <volume-name>
    ```
    
    For example:
    
    ```
    docker volume create myvolume
    ``` 
    
3.  **docker volume ls**: Use this command to list all the available volumes on the Docker host.
    
   ```
   docker volume ls
   ```
    
3.  **docker volume inspect**: This command allows you to view detailed information about a specific volume.
    
    ```
    docker volume inspect <volume-name>
    ```
    
    For example:

    ```
    docker volume inspect myvolume
    ```
    
5.  **docker volume rm**: Use this command to remove a volume. Note that you cannot remove a volume that is currently in use by a container.
    
   ```
   docker volume rm <volume-name>
   ```
    
    For example:
    
    ```
    docker volume rm myvolume
    ``` 
    
5.  **docker volume prune**: This command removes all unused volumes from the Docker host.
    
    ```
    docker volume prune
    ```
    
    Running this command will prompt for confirmation before removing the unused volumes.
    
7.  **docker run with a volume**: You can use the `-v` or `--volume` option with the `docker run` command to create and mount a volume during container creation.
    
    ```
    docker run -v <volume-name>:<container-path> ...
    ```
    
    For example, to create and mount a volume named `myvolume` to the `/app/data` directory inside the container:
    
    ```
    docker run -v myvolume:/app/data ...
    ```
    

These are some of the essential commands for managing Docker volumes. Volumes are useful for persisting and sharing data between containers, and they provide a convenient way to manage data associated with Dockerized applications.
