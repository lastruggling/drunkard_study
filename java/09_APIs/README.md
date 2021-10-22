# APIs
今までついて来たなら、何度も書いたこれがやっと分かるはず

```java
System.out.println()
```

Systemはクラスに見える。うむうむ。

outは、Systemの後ろのドットで読んでるから、変数だろう。うむうむ。

Systemクラスを生成してなく呼び込んでるから、outはStatic。

outの後ろにまたドットが出るのみたら、outもなにかのインスタンスだろう。うむうむ。

つまり、Systemなんちゃらも、何回か使ったRandomも誰かが作ったクラスに過ぎなく、

それを読み込んでるだけ。

# Javaがすでに提供してる
Randomが登場したとき、`import java.util.Random;`があるのを見たはず。

これは「Javaが提供するRandomクラスを利用したいから、入れて(Import)」の意味。

後日「Package」に関しても話が出るけど、もちろん自分のPackageを作成するのも可能。

# どこに何があるかどうわかる？
もちろんJavaのAPIドキュメントがある。

https://docs.oracle.com/en/java/javase/11/docs/api/index.html

APIドキュメントというから、本とかで「APIの利用」とかのチャプターがあるはず。(基本書もってなくてわからない)

これの探し方とかは、自分で勉強しましょう

https://www.sejuku.net/blog/33352

日本語で説明してるから一読おすすめ

# いじって見るのは

## Scanner
何回も書いたSystem.out.printlnは出力、もちろん入力もあるはず。

ぶっちゃけてJavaでは入力入れた記憶があまりないけど、常識的な感じで。

https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Scanner.html

### もっと踏み込んでみたいなら
実は出力も入力も、深入りするとすごく奥深い話になる。

SWでHWを操作するものになり、その間ではOSによっても違いがあるはず。

JavaはBytecodeを利用して共通云々がこういうところででるかね。

興味ある人は探してみてもよいかと。もはやプログラミングではなくコンピュター工学の領域だけど。

## ArrayList
他の言語を見たなら、「配列」か「Array」などが結構前に出る。

```java
int[] intArray = new int[3];
intArray[0] = 10;
intArray[1] = 20;
intArray[2] = 30;

String[] strArray = {"uno", "dos", "tres", "quatro"};
for(int idx = 0 ; idx < 4 ; idx++) {
    System.out.println(idx+1 + "はスペイン語で " + strArray[idx] + "!")
}
```
でも普通のarrayだと、**プログラムの始まりから終わりまで同じサイズになる。**

Arrayに何個の要素が入るか決まってないと、これは困るね。

そういうとき自動的に増やしてリしてくれるように、ArrayListというのを提供してる。

### ならばArrayListに同一しちゃえばいいじゃん？
これもまた深くなりがちの話。

Machine Learningをちょっといじってみたけど、「配列の配列」、通常多次元配列が出たりする。

ArrayListだとそれができなくなる。

### ArrayとArrayListの選択は簡単な方
https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/List.html

ArrayListはListというInterfaceをImplementしてるやつで、LinkedListとかもある。

また、VectorというArrayListとほぼ同じものもある。

これはJavaとはまた別の、Data structureの領域の話。コンピュター工学専攻で最も大事な授業とも選ばれる。

どれを使うべきかをちゃんと把握してる人は多分あまりないと思うね。

https://stackoverflow.com/questions/2986296/what-are-the-differences-between-arraylist-and-vector

こんな漢字で、「何が違うんですか」「なんで使わないですか」とかの質問がたくさんある。

**要は、そんな気にせず色々いじってみて、これはなんのためだ位をわかればいい話。**

色々興味できたけどわからない場合は聞いて。

# 興味ができたら
https://www.baeldung.com/java-collections

このサイトが本当に説明がうまく、仕事中結構パクってた。

CollectionsはJavaよりもプログラミング自体の次元で大事な概念だから

そこのコードを真似するだけでも役に立つと思う。