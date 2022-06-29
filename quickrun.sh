mvn clean
mvn package spring-boot:repackage

user='root'
host='llynsyw.cn'
workspace='~'
scp ./target/*.jar $user@$host:$workspace
ssh $user@$host "kill -9 \`lsof -i:8080\`;java -jar ~/asclepius-0.0.1-SNAPSHOT.jar"
