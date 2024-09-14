from flask import Flask
import os
import psycopg2

app = Flask(__name__)

DATABASE_URL = os.environ.get('DATABASE_URL')

@app.route('/')
def index():
    try:
        conn = psycopg2.connect(DATABASE_URL)
        return "Connected to the database!"
    except Exception as e:
        return f"Error connecting to the database: {str(e)}"

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=5000)
