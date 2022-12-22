FROM node:14

WORKDIR /app

COPY package.json /app



RUN npm i sequelize -g
RUN npm i sequelize-bcrypt

RUN npm install -g nodemon 
RUN yarn 

COPY . .

EXPOSE 8080

CMD npm run start


