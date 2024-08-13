FROM ubuntu

WORKDIR /app

COPY requirements.txt /app
COPY devops /app

RUN apt-get update && \
    apt-get install -y python3 python3-pip && \
    #pip install -r requirements.txt && \ # this is abhi command
    # this is asif command
    pip install Django --break-system-packages  && \ 
    # this is asif command
    pip install tzdata --break-system-packages  && \ 
    cd devops

ENTRYPOINT ["python3"]
CMD ["manage.py", "runserver", "0.0.0.0:8000"]




