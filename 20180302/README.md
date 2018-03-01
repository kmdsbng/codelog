

https://qiita.com/joooee0000/items/2d5935ec30ec73555eb2

ここを見てswaggerのモックを作成



nodejsのモックサーバ作成
java -jar swagger-codegen-cli-2.2.2.jar generate -i swagger.yaml -l nodejs-server -o samples/nodejs_server


typescriptコード生成

java -jar swagger-codegen-cli-2.2.2.jar generate -i swagger.yaml -l typescript-fetch -o samples/typescript_fetch


fetch APIの呼び出しサンプル

API.getOutline({
      year: year
    },{
      headers: {Authorization: KeycloakAdapter.getBearerToken()}
    })().then((response: OutlineResponse) => {
      let departments = response.outlines.map((outline: Outline) => {
        ...
      })
    })




