FROM node:14

# Set the working directory
WORKDIR /app

# Copy the package.json and pakage-lock files

COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application code
COPY . .

# Expose the application port
EXPOSE 3000

# Start the Express app
CMD [ "node", "app.js" ]