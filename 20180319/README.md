
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

echo "version 3" > test2.txt
git hash-object -w test2.txt
> 7170a5278f42ea12d4b6de8ed1305af8c393e756
git update-index --add --cacheinfo 100644 7170a5278f42ea12d4b6de8ed1305af8c393e756 test2.txt

git write-tree
> 6595438e5b065f70e0dda0c76b241ef2eefb18fd

echo "commit by git commit-tree" | git commit-tree f164ec4c3115574bd16af333b26c62e25857bb25
> fe9fa410e4a0a8611afcbf27469deceb8d13e6b9
echo "commit test2" | git commit-tree 690f3cd0b5a819042b764eda395a673920d9fda1 -p fe9fa410e4a0a8611afcbf27469deceb8d13e6b9
> 64dff1a238ef62e2561c066aefb407420da0c1d8
echo "commit test3" | git commit-tree 878c156913c53033d0c4df664ed8754f6f13aee5 -p 64dff1a238ef62e2561c066aefb407420da0c1d8
> 95123c03850ea59aa7158f30004bfea9943053d4
git log 95123c03850ea59aa7158f30004bfea9943053d4

find .git/objects -type f # 作ったオブジェクト一覧(blob, tree, commit)を表示
```

