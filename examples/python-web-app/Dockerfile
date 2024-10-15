FROM ubuntu

WORKDIR /app

# Copy necessary files
COPY requirements.txt /app
COPY devops /app

# Update and install dependencies
RUN apt-get update && \
    apt-get install -y python3 python3-pip python3-venv && \
    python3 -m venv /app/venv && \
    /app/venv/bin/pip install --upgrade pip && \
    /app/venv/bin/pip install -r requirements.txt

# Set environment variable to use the virtual environment
ENV PATH="/app/venv/bin:$PATH"

# Set working directory and entry point
WORKDIR /app/devops
ENTRYPOINT ["python3"]
CMD ["manage.py", "runserver", "0.0.0.0:8000"]
