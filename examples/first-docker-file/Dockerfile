# Use the official python image from docker hub
FROM python:3.9-slim

# Set the working directory in the container
WORKDIR /app

# Copy the requirements file into the container

COPY requirements.txt .

# Install the dependencies
RUN pip install -r requirements.txt

# Copy the rest of the application into the container
COPY . .

# EXpose the port the application
EXPOSE 5000

# Define the command to run the application

CMD [ "python", "app.py" ]
