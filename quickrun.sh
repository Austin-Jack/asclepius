mvn clean
mvn package spring-boot:repackage

scp ./target/*.jar ubuntu@101.35.79.162:/home/ubuntu
#pid=\`lsof -i:80 -t\` && kill -9 $pid &&
ssh ubuntu@101.35.79.162 "sudo java -jar ~/asclepius-0.0.1-SNAPSHOT.jar"
