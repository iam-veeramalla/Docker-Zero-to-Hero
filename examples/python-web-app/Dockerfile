FROM ubuntu

# Set the working directory in the container
WORKDIR /app

# Copy the requirements file and devops directory into the container
COPY requirements.txt /app
COPY devops /app

# Install Python and other necessary tools
RUN apt-get update && \
    apt-get install -y python3 python3-pip python3-venv && \
    python3 -m venv /app/venv && \
    /app/venv/bin/pip install --upgrade pip && \
    /app/venv/bin/pip install -r requirements.txt

# Set the PATH to ensure the virtual environment is used
ENV PATH="/app/venv/bin:$PATH"

# Expose the necessary port
EXPOSE 8000

# Run the Django development server
ENTRYPOINT ["python3"]
CMD ["manage.py", "runserver", "0.0.0.0:8000"]





