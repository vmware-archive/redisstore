clear 
# mvn spring-boot:run
# cf api api.run.pivotal.io
# cf login

mvn package
cf push
# cf push target/redisstore-1.0.0-SNAPSHOT.jar

