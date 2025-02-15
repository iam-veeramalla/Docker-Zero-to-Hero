# Optimizing Docker Images with Multi-Stage Builds

## Overview
This guide explains how multi-stage builds work in Docker to optimize image size, using Go as an example.

## Traditional Docker Build (Large Image)
```dockerfile
###########################################
# BASE IMAGE
###########################################

FROM ubuntu AS build

RUN apt-get update && apt-get install -y golang-go

ENV GO111MODULE=off

COPY . .

RUN CGO_ENABLED=0 go build -o /app .

ENTRYPOINT ["/app"]
```
### Breakdown
- Uses Ubuntu as the base image (~29MB).
- Installs Go (~500MB+).
- Copies source code and compiles it into an executable binary (`/app`).
- The final image size is **~600MB**.

## Optimized Multi-Stage Build (Small Image)
```dockerfile
###########################################
# BASE IMAGE (Build Stage)
###########################################

FROM ubuntu AS build

RUN apt-get update && apt-get install -y golang-go

ENV GO111MODULE=off

COPY . .

RUN CGO_ENABLED=0 go build -o /app .

############################################
# FINAL STAGE (Minimal Runtime)
############################################

FROM scratch

COPY --from=build /app /app

ENTRYPOINT ["/app"]
```
### Why is This Smaller?
1. **First stage (Ubuntu-based)**
   - Builds the executable binary using Ubuntu and Go.
   - The build container is **temporary** and discarded after compilation.

2. **Second stage (Scratch-based)**
   - Uses `scratch`, an empty base image (0KB).
   - Copies only the compiled binary (`/app`) from the first stage.
   - No OS, no package manager, no extra dependencies.

### Result
- **Final Image Size:** **~1.8MB** (only the Go binary).
- **No Ubuntu, No Go Compiler** in the final image.

## Understanding the Binary File
A **binary** is an executable file produced after compilation. In this case:
- `go build -o /app .` generates `/app`, which is a self-contained executable.
- The binary can run independently without Go or Ubuntu.

## Benefits of Multi-Stage Builds
✅ **Reduces Image Size** → From **600MB to 1.8MB**.
✅ **Enhances Security** → No extra tools, fewer vulnerabilities.
✅ **Speeds Up Deployment** → Smaller images load faster.
✅ **Optimized Performance** → Only the necessary binary is included.

## When to Use Multi-Stage Builds
Multi-stage builds are ideal for:
- **Compiled languages** like Go, Rust, and C++.
- **Reducing Docker image size** for production.
- **Minimizing attack surface** in containerized applications.

## Summary
| Step                | Base Image Used | Size     | Contents                         |
|--------------------|---------------|---------|---------------------------------|
| **Build Stage**    | Ubuntu        | ~600MB  | Go compiler, source code, binary |
| **Final Image**    | Scratch       | ~1.8MB  | Only the compiled binary (`/app`) |

#NOTE
####SCRACTCH Wont work for all application for example python require python run time during that time you can use python distroless images
### 🔥 **Where to Get Distroless Images?**  

Distroless images are maintained by **Google** and are hosted on **Google Container Registry (GCR)** and **Artifact Registry (AR)**. You can pull them directly using Docker.  

---

## 📌 ** Official Distroless Image Repository**  
✅ **GitHub Repository:** [https://github.com/GoogleContainerTools/distroless](https://github.com/GoogleContainerTools/distroless)  
✅ **Docker Hub (Mirrored):** [https://hub.docker.com/r/gcr.io/distroless](https://hub.docker.com/r/gcr.io/distroless)  


## 🚀 **Why Use Distroless?**
✅ **Ultra-small image size** (no package manager, no shell)  
✅ **More secure** (reduces attack surface)  
✅ **Faster startup times** (optimized for production)  

Would you like help setting up a GitHub Actions workflow using distroless? 🚀

