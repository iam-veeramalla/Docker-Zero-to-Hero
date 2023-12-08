FROM ubuntu

WORKDIR /workflow

COPY requirements.txt /workflow
COPY devops /workflow

RUN apt-get update && \
    apt-get install -y python3 python3-pip && \
    pip install -r requirements.txt && \
    cd devops

ENTRYPOINT ["python3"]
CMD ["manage.py", "runserver", "0.0.0.0:80"]




