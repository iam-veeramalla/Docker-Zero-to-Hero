FROM ubuntu

# Set the working directory in the container
WORKDIR /app

# Copy requirements.txt and the devops directory into the container
COPY requirements.txt /app/
COPY devops /app/devops

# Install Python 3 and pip, and install Python dependencies from requirements.txt
RUN apt-get update && \
    apt-get install -y python3 python3-pip && \
    pip3 install -r requirements.txt

# Set the command to be executed when the container starts
CMD ["python3", "devops/manage.py", "runserver", "0.0.0.0:8000"]



# FROM ubuntu

# WORKDIR /app

# COPY requirements.txt /app
# COPY devops /app

# RUN apt-get update && \
#     apt-get install -y python3 python3-pip && \
#     pip install -r requirements.txt && \
#     cd devops

# ENTRYPOINT ["python3"]
# CMD ["manage.py", "runserver", "0.0.0.0:8000"]




