FROM ubuntu

# Set working directory
WORKDIR /app

# Copy necessary files
COPY requirements.txt /app
COPY devops /app

# Install dependencies
RUN apt-get update && \
    apt-get install -y python3 python3-pip python3-venv && \
    python3 -m venv /app/venv && \
    /app/venv/bin/pip install -r requirements.txt

# Set the virtual environment's Python as the default
ENV PATH="/app/venv/bin:$PATH"

# Set entrypoint and command
ENTRYPOINT ["python3"]
CMD ["manage.py", "runserver", "0.0.0.0:8000"]




