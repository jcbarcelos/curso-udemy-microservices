FROM node:14

WORKDIR /app

COPY package.json /app

RUN  npm install -g nodemon 
RUN  npm install 

COPY . .

EXPOSE 8082

CMD npm run start