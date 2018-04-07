https://docs.docker.com/get-started/part3/#about-services

docker swarm と docker-compose.yml のサンプル


```
docker swarm init

docker-compose.ymlの内容に従ってサービス起動。また、docker-compose.ymlの内容を変更して
サービスに適用したいときもこのコマンドを使う。
docker stack deploy -c docker-compose.yml getstartedlab

docker service ls

サービスに含まれるコンテナ一覧
docker service ps getstartedlab_web

コンテナID一覧
docker container ls -q

docker stack rm getstartedlab

docker swarm leave --force

```


