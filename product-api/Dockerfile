FROM gradle

WORKDIR /app

COPY --chown=gradle:gradle . .

RUN gradle build -x test --no-daemon

EXPOSE 8081

CMD [ "gradle", "bootRun" ]