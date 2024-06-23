FROM ubuntu

WORKDIR /app

COPY requirements.txt /app
COPY devops /app

RUN apt-get update && \
    apt-get install -y python3 python3-pip python3-venv && \
    # Create a virtual environment
    python3 -m venv venv && \
    # Activate the virtual environment
    . venv/bin/activate && \
    pip install -r requirements.txt && \
    cd devops

ENTRYPOINT ["venv/bin/python3"]
CMD ["manage.py", "runserver", "0.0.0.0:8000"]




