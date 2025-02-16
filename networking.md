# Docker Networking

Networking allows containers to communicate with each other and with the host system. Containers run isolated from the host system and need a way to communicate with each other and with the host system.

By default, Docker provides two network drivers for you, the bridge and the overlay drivers.

## Listing Docker Networks

```sh
docker network ls
```

This command lists all available Docker networks.

**Output Example:**

```
NETWORK ID          NAME                DRIVER
xxxxxxxxxxxx        none                null
xxxxxxxxxxxx        host                host
xxxxxxxxxxxx        bridge              bridge
```

## Bridge Networking

The default network mode in Docker. It creates a private network between the host and containers, allowing containers to communicate with each other and with the host system.

### Creating a Custom Bridge Network

```sh
docker network create -d bridge my_bridge
```

**Flags:**
- `-d bridge` → Specifies the network driver (in this case, `bridge`).

After running this command, if you list the Docker networks again, you will see the newly created `my_bridge` network:

```sh
docker network ls
```

**Output Example:**

```
NETWORK ID          NAME                DRIVER
xxxxxxxxxxxx        bridge              bridge
xxxxxxxxxxxx        my_bridge           bridge
xxxxxxxxxxxx        none                null
xxxxxxxxxxxx        host                host
```

### Running a Container in the Custom Bridge Network

```sh
docker run -d --net=my_bridge --name db training/postgres
```

**Flags:**
- `-d` → Runs the container in detached mode.
- `--net=my_bridge` → Attaches the container to the `my_bridge` network.
- `--name db` → Assigns the container the name `db`.

This way, you can run multiple containers on a single host platform where one container is attached to the default network and the other is attached to the `my_bridge` network. These containers are completely isolated and cannot communicate with each other.

### Connecting a Container to Another Network

```sh
docker network connect my_bridge web
```

This command attaches the existing `web` container to the `my_bridge` network, enabling communication between containers in that network.

## Host Networking

This mode allows containers to share the host system's network stack, providing direct access to the host system's network.

### Running a Container with Host Networking

```sh
docker run --network="host" <image_name> <command>
```

**Flags:**
- `--network="host"` → Uses the host's network stack instead of an isolated network.

When using the host network, the container has access to the host's network resources and uses the same IP address and network configuration as the host. This reduces isolation and may pose security risks.

## Overlay Networking

This mode enables communication between containers across multiple Docker host machines, allowing containers to be connected to a single network even when they are running on different hosts.

## Macvlan Networking

This mode allows a container to appear on the network as a physical host rather than as a container.

---

Using different Docker networking modes, you can manage communication between containers efficiently while ensuring security and flexibility in your architecture.

