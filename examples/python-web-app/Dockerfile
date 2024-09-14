FROM ubuntu

WORKDIR /app

COPY requirements.txt .

RUN apt-get update && \
    apt-get install -y python3 python3-pip && \
    pip3 install --no-cache-dir -r requirements.txt

COPY devops /app/devops

CMD ["python3", "devops/manage.py", "runserver", "0.0.0.0:8000"]

