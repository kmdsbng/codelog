

gradle shadow plugin を使うテスト

http://imperceptiblethoughts.com/shadow/

./gradlew shadowJar で jarファイルを作成できる。

gradle-fatjar-plugin はもうメンテされてなくて、META-INFディレクトリに不要な署名ファイルが
入ってしまい、jarからクラスをロードできなくなってしまうことがあるため、gradle shadow pluginを
使ったほうがいい。




