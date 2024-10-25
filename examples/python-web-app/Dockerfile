# Use Ubuntu as the base image
FROM ubuntu:latest

# Set working directory
WORKDIR /app

# Copy requirements.txt and application files to the container
COPY requirements.txt /app/
COPY devops /app/devops

# Install Python and pip, then create a virtual environment
RUN apt-get update && \
    apt-get install -y python3 python3-pip python3-venv && \
    python3 -m venv venv && \
    . venv/bin/activate && \
    pip install -r requirements.txt

# Use the virtual environment to run the application
ENTRYPOINT ["venv/bin/python", "devops/manage.py"]
CMD ["runserver", "0.0.0.0:8000"]




