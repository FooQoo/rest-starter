# REST STARTER

## Running Locally
Make sure you have Java and Maven installed.  Also, install the [Heroku CLI](https://cli.heroku.com/).

```bash
$ ./gradlew clean build
$ heroku local:start --port=8080
```

## Deploying to Heroku
```bash
$ heroku create rest-starter 
$ heroku addons:create cleardb:ignite
$ git push heroku main
$ heroku open
```

## Documentation

For more information about using Java on Heroku, see these Dev Center articles:

- [Java on Heroku](https://devcenter.heroku.com/categories/java)

