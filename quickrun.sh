mvn clean
mvn package spring-boot:repackage -DskipTests

user='root'
workspace='~/asclepius'
for host in 101.35.79.162 47.106.221.6 49.232.196.77
do
  scp ./target/*.jar $user@$host:$workspace
  ssh $user@$host "cd ~/asclepius;docker rm -f as;docker rmi asclepius:1.0;docker build -f dockerFile -t asclepius:1.0 .;
  docker run -d --restart=always -v /root/asclepius:/root/asclepius --network host --name as asclepius:1.0"
done
