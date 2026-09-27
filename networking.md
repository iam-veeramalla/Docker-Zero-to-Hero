# Docker Networking

Networking allows containers to communicate with each other and with the host system. Containers run isolated from the host system
and need a way to communicate with each other and with the host system.

By default, Docker provides two network drivers for you, the bridge and the overlay drivers. 

```
docker network ls
```

```
NETWORK ID          NAME                DRIVER
xxxxxxxxxxxx        none                null
xxxxxxxxxxxx        host                host
xxxxxxxxxxxx        bridge              bridge
```


### Bridge Networking

The bridge driver connects containers on a single Docker host. Docker creates a default bridge network automatically, and you can create
user-defined bridge networks when you need separate application networks.

![image](https://user-images.githubusercontent.com/43399466/217745543-f40e5614-ac34-4b78-85a9-91b24512388d.png)

Containers on the same user-defined bridge can communicate with each other and resolve each other by container name. Different bridge
networks are isolated from one another by default, but containers may still reach ports published by containers on other networks.
Containers on different bridges can communicate directly when connected to a shared network. To create a user-defined bridge:

```
docker network create -d bridge my_bridge
```

Start a web server on that network:

```
docker run -d --rm --name web --network my_bridge nginx:alpine
```

From another container on the same network, use the name `web` to reach it:

```
docker run --rm --network my_bridge alpine:latest wget -qO- http://web
```

The command prints the web server's default page. Remove the web container and network when finished:

```
docker stop web
docker network rm my_bridge
```

The default bridge network differs from a user-defined bridge: containers on the default bridge generally need IP addresses to
communicate with one another, while user-defined bridges provide name-based DNS discovery. Publishing a container port with `-p`
allows access through a host port; containers do not need published ports to communicate over the same bridge.

### Host Networking

This mode allows containers to share the host system's network stack, providing direct access to the host system's network.

To attach a host network to a Docker container, you can use the --network="host" option when running a docker run command. When you use this option, the container has access to the host's network stack, and shares the host's network namespace. This means that the container will use the same IP address and network configuration as the host.

Here's an example of how to run a Docker container with the host network:

```
docker run --network="host" <image_name> <command>
```

Keep in mind that when you use the host network, the container is less isolated from the host system, and has access to all of the host's network resources. This can be a security risk, so use the host network with caution.

Additionally, not all Docker image and command combinations are compatible with the host network, so it's important to check the image documentation or run the image with the --network="bridge" option (the default network mode) first to see if there are any compatibility issues.

### Overlay Networking

This mode enables communication between containers across multiple Docker host machines, allowing containers to be connected to a single network even when they are running on different hosts.

### Macvlan Networking

This mode allows a container to appear on the network as a physical host rather than as a container.
