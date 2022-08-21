# Rest Starter

## Running Locally

Make sure you have Java and Maven installed. Also, install the [Heroku CLI](https://cli.heroku.com/).

```bash
$ heroku create rest-starter 
$ heroku addons:create cleardb:ignite
$ heroku config:get CLEARDB_DATABASE_URL  -s  >> .env

$ ./gradlew clean build
$ heroku local:start --port=8080
```

## Deploying to Heroku

```bash
$ git push heroku main
$ heroku open
```

## Documentation

For more information about using Java on Heroku, see these Dev Center articles:

- [Java on Heroku](https://devcenter.heroku.com/categories/java)

