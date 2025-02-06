# Use an official Ubuntu as a base image
FROM ubuntu:latest

# Set the working directory inside the container
WORKDIR /app

# Install necessary dependencies (Python, pip, venv)
RUN apt-get update && \
    apt-get install -y python3 python3-pip python3-venv

# Create and activate a virtual environment
RUN python3 -m venv /venv

# Upgrade pip inside the virtual environment
RUN /venv/bin/pip install --upgrade pip

# Copy the requirements file into the container
COPY requirements.txt .

# Install the Python dependencies into the virtual environment
RUN /venv/bin/pip install -r requirements.txt

# Copy the rest of the application files
COPY . /app

# Set environment variable (optional)
ENV NAME World

# Add virtual environment's binary folder to PATH
ENV PATH="/venv/bin:$PATH"

# Set the command to run your app (using the virtual environment's Python)
CMD ["python3", "app.py"]
