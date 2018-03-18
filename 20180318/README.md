
git の内部構造の勉強

https://git-scm.com/book/ja/v2/Git%E3%81%AE%E5%86%85%E5%81%B4-Git%E3%82%AA%E3%83%96%E3%82%B8%E3%82%A7%E3%82%AF%E3%83%88

# ハッシュオブジェクトを作ってリポジトリに格納する
git hash-object -w test.txt

# コンテンツをgitから取り出す
git cat-file -p d670460b4b4aece5915caf5c68d12f560a9fe3e4


git の配管コマンドのサンプル

```
echo 'version 1' > test.txt
git hash-object -w test.txt

echo 'version 2' > test.txt
git hash-object -w test.txt

find .git/objects -type f

git cat-file -p 1f7a7a472abf3dd9643fd615f6da379c4acb3e3a > test.txt
cat test.txt
```

