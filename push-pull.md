# Docker Hub: Push and Pull Containers

This guide explains how to **push** and **pull** Docker images to and from Docker Hub.

## Prerequisites
- Docker installed on your system
- A [Docker Hub account](https://hub.docker.com/)
- Logged in to Docker Hub (`docker login`)

---

## **Pulling an Image from Docker Hub**
To download a Docker image from Docker Hub, use the `docker pull` command.

### **Command:**
```bash
docker pull <image_name>:<tag>
```
### **Example:**
```bash
docker pull nginx:latest
```
### **Explanation:**
- `docker pull` → Downloads an image from Docker Hub
- `nginx` → Image name
- `latest` → (Optional) Specifies the tag/version (default is `latest`)

To verify that the image is downloaded:
```bash
docker images
```

---

## **Pushing an Image to Docker Hub**
To upload an image to Docker Hub, follow these steps:

### **1. Tag the Image**
Docker requires an image to be tagged properly before pushing.

### **Command:**
```bash
docker tag <local_image> <dockerhub_username>/<repository>:<tag>
```
### **Example:**
```bash
docker tag my_app mydockerhubuser/my_app:1.0
```
### **Explanation:**
- `docker tag` → Assigns a repository name to an existing image
- `my_app` → Local image name
- `mydockerhubuser/my_app:1.0` → Format required for Docker Hub (`<username>/<repo>:<tag>`)

### **2. Log in to Docker Hub**
Before pushing, authenticate to Docker Hub:
```bash
docker login
```
It will prompt for your Docker Hub **username** and **password**.

### **3. Push the Image**
Now, push the tagged image to Docker Hub.

### **Command:**
```bash
docker push <dockerhub_username>/<repository>:<tag>
```
### **Example:**
```bash
docker push mydockerhubuser/my_app:1.0
```
### **Explanation:**
- `docker push` → Uploads the image to Docker Hub
- `mydockerhubuser/my_app:1.0` → The tagged image to push

### **4. Verify on Docker Hub**
Go to [Docker Hub](https://hub.docker.com/) and check your repository to confirm the image is uploaded.

---

## **Pull the Image on Another Machine**
To use the uploaded image on another system, run:
```bash
docker pull mydockerhubuser/my_app:1.0
```
Then, start a container from the image:
```bash
docker run -d --name my_container mydockerhubuser/my_app:1.0
```

---

## **Conclusion**
- Use `docker pull` to download images from Docker Hub.
- Use `docker push` to upload images to Docker Hub.
- Always **tag** images correctly before pushing.
- Use `docker login` before pushing private images.

Happy Dockering! 🚀

