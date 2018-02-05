# pcf-event-sentiment-ui

Upload the application with no-start flag
```
cf push -p target/sentiment-ui-0.0.1-SNAPSHOT.jar --no-start
```
Bind the right services:
* Registry
```
cf bs sentiment-ui registry
```
* Circuit breaker
```
cf bs sentiment-ui circuit-breaker
```

Start the application
```
cf start sentiment-ui
```
