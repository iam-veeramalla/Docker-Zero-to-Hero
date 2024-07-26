FROM ubuntu

WORKDIR /app

COPY requirements.txt /app
COPY devops /app

RUN apt-get update && \
    apt-get install -y python3 python3-venv && \
    python3 -m venv /venv && \
    /venv/bin/
    pip install -r requirements.txt && \
    cd devops

ENTRYPOINT ["venv/bin/python3"]
CMD ["manage.py", "runserver", "0.0.0.0:8000"]




