FROM ubuntu

WORKDIR /app

COPY requirements.txt /app
COPY devops /app

## refer this link for why we are setting environment variable https://veronneau.org/python-311-pip-and-breaking-system-packages.html
ENV PIP_BREAK_SYSTEM_PACKAGES 1

RUN apt-get update && \
    apt-get install -y python3 python3-pip && \
    pip install -r requirements.txt && \
    cd devops

ENTRYPOINT ["python3"]
CMD ["manage.py", "runserver", "0.0.0.0:8000"]




