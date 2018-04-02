mvn clean install
docker stop trygraal || true
docker rm trygraal || true
docker rmi rahmanusta/trygraal || true
docker build -t rahmanusta/trygraal .
docker run -i -d --restart unless-stopped -p 80:80 --name trygraal rahmanusta/trygraal