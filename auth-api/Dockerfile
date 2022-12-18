FROM node:14

WORKDIR /app

COPY package.json /app

RUN yarn

COPY . .

EXPOSE 8080

CMD [ "node", "src/app.js" ]


