###########################################
# BASE IMAGE
###########################################

FROM ubuntu AS build

RUN apt-get update && apt-get install -y golang-go

ENV GO111MODULE=off

COPY . . 
# . (first dot) → Represents the source (the current directory where the Dockerfile is located).
# . (second dot) → Represents the destination (the working directory inside the Docker container).

RUN CGO_ENABLED=0 go build -o /app .

ENTRYPOINT ["/app"]

