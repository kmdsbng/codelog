

# nginx imageをインストールして実行
docker run --name some-nginx -d -p 9090:80 nginx

# docker containerを停止
docker stop 8aff1cdcce5b

# docker container一覧を表示
docker ps

# 停止してるcontainer一覧も表示
docker ps -a

# imageをダウンロードするだけならpullを使う
docker pull wordpress

# docker containerを削除する
docker rm 28af19ab1b8f 8aff1cdcce5b

# docker imageを削除する
docker rmi 346b1443b020 1b155f07a3fa 5195076672a7 f975c5035748 f2a91732366c 31a931f8663b 25d6a2630f58 68ae6ddab7e9

# docker image一覧を表示
docker images

# containerがないimageも含めて一覧を表示
docker images -a

