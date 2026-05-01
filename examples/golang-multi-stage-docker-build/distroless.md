FROM node:18 AS build  

WORKDIR /app  
COPY . .  
RUN npm install  

FROM `gcr.io/distroless/nodejs`  

COPY --from=build /app /app  

WORKDIR /app  

CMD ["app.js"]  
