FROM ubuntu:20.04

# Set working directory
WORKDIR /app

# Copy files
COPY requirements.txt /app
COPY devops /app/devops

# Install dependencies
RUN apt-get update && \
    apt-get install -y python3 python3-pip && \
    pip install --no-cache-dir -r requirements.txt && \
    rm -rf /var/lib/apt/lists/*

# Set working directory to devops
WORKDIR /app/devops

# Set entry point for the container
ENTRYPOINT ["python3"]
CMD ["manage.py", "runserver", "0.0.0.0:8000"]
