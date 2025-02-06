# Stage 1: Build stage
FROM python:3.9 as builder
WORKDIR /app
COPY app.py .

# Stage 2: Final stage with distroless image
FROM gcr.io/distroless/python3-debian11
WORKDIR /app
COPY --from=builder /app/app.py .

CMD ["app.py"]

