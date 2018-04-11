
コンテナが達成したいこと: 信頼性を高める

ここでGit同期サーバがメモリリークを起こすバグを抱えているとしましょう。2つのサーバが1つのコンテナ上で動いていると、Git同期サーバのメモリリークはWebサーバのパフォーマンスに影響したり、最悪の場合Webサーバをクラッシュさせてしまう可能性があります。そのため、Webサーバが必ずメモリを使えるようにするため、Git同期サーバがメモリを使い切らないように何らかの仕組みを作っておかなければなりません。
こういった問題を避けるためのリソースの分離の考え方は、まさにコンテナがうまく取り扱うべくデザインされたものです。2つのサーバを別々のコンテナに分けることで、Webサーバの処理の信頼性を高めることができます。


podは鯨の群のことで、鯨に関連する語を使うDockerの慣習に従っています。



通常は、Podを作る時に「このコンテナはそれぞれ違うマシンに配置されても正常に動作するかどうか」という点を考えてみるのがよいでしょう。答えが「動作しない」なら、コンテナをまとめる単位としてはPodが正しい選択です。答えが「動作する」なら、Podを分けるのが正解である可能性が高いでしょう。


Kubernetesの自己回復的な動作、すなわちユーザアクションなしにアプリケーションを動かし続ける仕組みは、宣言的設定を土台にしています。


Kubernetes APIサーバは、Podマニフェストを受け入れ、その後永続化ストレージ（etcd）に保存します。


ノードにリソースが十分にあれば、1つのノードに複数の同じPodが割り当てられることもあります。しかし、同じアプリケーションの複数のPodを同一ノードに割り当てるのは、障害の影響を受ける範囲が一緒になってしまうので、信頼性の点ではよくありません。そのためノードの障害などに対する信頼性の観点から、Kubernetesスケジューラは同じアプリケーションのPodを別々のノードに分散しようとします。Podがノードに割り当てられると、明示的に削除したり割り当て直したりしない限り、そのPodは同じノード上で動き続けます。


コンテナやKubernetesのようなコンテナオーケストレータを使い始める時の理由として、これらの仕組みがイメージのパッケージングや信頼性の高いデプロイを劇的に改善してくれるという点がよく挙げられます。アプリケーション指向の仕組みによって分散システムの開発がシンプルになるという基本的な機能に加えて、クラスタを構成するノードの全体の使用率を上げる能力も同じように重要です。仮想か物理かによらず、アイドル状態だろうと全力で処理を行っていようと、マシンを運用する基本的コストは一定です。そのため、インフラへの投資の効率性を上げるには、それぞれのマシンを最大限に使用することが求められます。


# Podを作成する
kubectl run kuard --image=kmdsbng/kuard-amd64:1


# Podの状態を見る
kubectl get pods


# Podを削除する
kubectl delete deployments/kuard


# Podマニフェストを使ってPodを作成する
kubectl apply -f kuard-pod.yaml


# Podを削除する
kubectl delete pods/kuard

# Podの詳しい説明を観る
kubectl describe pods kuard

# Podにアクセスするためのセキュアなトンネルを作る
kubectl port-forward kuard 8080:8080

# コンテナ内でコマンドを実行
kubectl exec kuard date

# コンテナにファイルをコピー(逆もOK)
kubectl cp config.txt kuard:/config.txt




# 6章

Labelは、オブジェクトのメタデータを特定するためのものです。Labelは、オブジェクトをグループ化したり、一覧表示したり、操作したりする際の基本的機能です。

# ラベルを付けてPodを作成する
kubectl run alpaca-prod --image=kmdsbng/kuard-amd64:1 --replicas=2 --labels="ver=1,app=alpaca,env=prod"

# ラベルを確認
kubectl get deployments --show-labels
kubectl get pods --show-labels

# 作成した後でオブジェクトにラベルを付ける
kubectl label deployments alpaca-test "canary=true"

# 列単位でラベルを確認する
kubectl get deployments -L canary

# deploymentsをすべて削除
kubectl delete deployments --all


