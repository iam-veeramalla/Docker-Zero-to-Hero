## ========== STAGE 1 : BUILD ==============
FROM ubuntu as build 

WORKDIR /app

# Install python + pip (only needed to install dependencies, not to run them later)

RUN apt update && apt install -y python3 python3-pip

# Copy dependency list first<LeftMouse> (better layer caching)

COPY requirements.txt /app/

# Install dependencies into a local target folder so we can copy
# just the installed packages into the final stage (not pip/apt/build tools)

RUN pip install --no-cache-dir --target=/app/dependencies -r requirements.txt

# copy the actual source code 

COPY . /app

### =========== STAGE 2 : MULTISTAGE (FINAL (RUNTIME) )========== #####

FROM python:3.12-slim

WORKDIR /app

# Copy installed python dependenices from the build stage 

COPY --from=build /app/dependencies /usr/local/lib/python3.12/site-packages


# Copy application source code 

COPY --from=build /app /app
	
ENTRYPOINT ["python3"]
CMD ["manage.py", "runserver", "0.0.0.0:8000"]
