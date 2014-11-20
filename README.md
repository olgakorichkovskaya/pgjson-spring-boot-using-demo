pgjson-spring-boot-using-demo
=============================

Demo of using pgjson (https://github.com/bazar-nazar/pgjson) with Spring Boot

It is interesting, that pgjson work properly for tests, but main application don't start :
```
Caused by: java.lang.NoClassDefFoundError: Could not initialize class demo.Custom
```
Custom - class that stored as JSON

Testing of using Map and HashMap don't finished jet - configuraion should be fixed

Postgres 9.3 is used
