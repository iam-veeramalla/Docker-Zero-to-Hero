FROM ubuntu:latest
FROM gcc:latest

# Set the working directory in the image
WORKDIR /HelloWorld

# Copy the files from the host file system to the image file system
COPY . /HelloWorld

# Install the necessary packages
RUN apt-get update && apt-get install -y gcc

# Compile C Hello World Application
RUN gcc -o HelloWorld C-HelloWorld.c

# Run a command to start the application
CMD ["./HelloWorld"]
