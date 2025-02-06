# Docker Volumes

## Problem Statement

It is a very common requirement to persist the data in a Docker container beyond the lifetime of the container. However, the file system
of a Docker container is deleted/removed when the container dies. 

## Solution

There are 2 different ways how docker solves this problem.

1. Volumes
2. Bind Directory on a host as a Mount

### Volumes 

Volumes aims to solve the same problem by providing a way to store data on the host file system, separate from the container's file system, 
so that the data can persist even if the container is deleted and recreated.

![image](https://user-images.githubusercontent.com/43399466/218018334-286d8949-d155-4d55-80bc-24827b02f9b1.png)


Volumes can be created and managed using the docker volume command. You can create a new volume using the following command:

```
docker volume create <volume_name>
```

Once a volume is created, you can mount it to a container using the -v or --mount option when running a docker run command. 

For example:

```
docker run -it -v <volume_name>:/data <image_name> /bin/bash
```

This command will mount the volume <volume_name> to the /data directory in the container. Any data written to the /data directory
inside the container will be persisted in the volume on the host file system.

### Bind Directory on a host as a Mount

Bind mounts also aims to solve the same problem but in a complete different way.

Using this way, user can mount a directory from the host file system into a container. Bind mounts have the same behavior as volumes, but
are specified using a host path instead of a volume name. 

For example, 

```
docker run -it -v <host_path>:<container_path> <image_name> /bin/bash
```

## Key Differences between Volumes and Bind Directory on a host as a Mount

Volumes are managed, created, mounted and deleted using the Docker API. However, Volumes are more flexible than bind mounts, as 
they can be managed and backed up separately from the host file system, and can be moved between containers and hosts.

In a nutshell, Bind Directory on a host as a Mount are appropriate for simple use cases where you need to mount a directory from the host file system into
a container, while volumes are better suited for more complex use cases where you need more control over the data being persisted
in the container.

Sure, here's a comprehensive guide to Docker networking, volumes, and mounts in Markdown format:

## Docker Volumes Commands
### Basics

- **List volumes**: `docker volume ls`
- **Inspect a volume**: `docker volume inspect VOLUME_NAME`
- **Create a volume**: `docker volume create VOLUME_NAME`
- **Remove a volume**: `docker volume rm VOLUME_NAME`

### Advanced

- **Bind mount**: Maps a host file or directory to a container file or directory.
  - `docker run -v /host/path:/container/path IMAGE_NAME`
- **Anonymous volume**: Automatically created by Docker and managed internally. Useful for temporary data.
  - `docker run -v /container/path IMAGE_NAME`
- **Named volume**: Allows you to manage volumes independently of containers.
  - `docker run -v VOLUME_NAME:/container/path IMAGE_NAME`
- **Remote volume**: Docker supports various volume drivers for remote storage systems like NFS, AWS EBS, etc.
  - `docker volume create --driver DRIVER_NAME VOLUME_NAME`

## Docker Mounts

### Basics

- **Bind mount**: Maps a host file or directory to a container file or directory.
  - `docker run --mount type=bind,source=/host/path,target=/container/path IMAGE_NAME`
- **Volume mount**: Uses a named or anonymous volume.
  - `docker run --mount source=VOLUME_NAME,target=/container/path IMAGE_NAME`

### Advanced

- **TMPFS mount**: Mounts a temporary file system inside the container's memory.
  - `docker run --mount type=tmpfs,destination=/container/path IMAGE_NAME`
- **Named pipe mount**: Provides a way for processes to communicate with each other using named pipes.
  - `docker run --mount type=pipe,source=PIPE_NAME,target=/container/path IMAGE_NAME`
- **Secret mount**: Used to provide sensitive information securely to containers.
  - `docker run --mount type=secret,source=SECRET_NAME,target=/container/path IMAGE_NAME`

