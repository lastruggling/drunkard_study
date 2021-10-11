# Abstract
Abstractは辞書的な意味で「抽象的」 。オブジェクトではないけど、オブジェクトのように説明はできる

例えば、「りんご」「バナナ」は実態がある。そういうのを「果物」とは言うけど、「果物」自体のオブジェクトはない。

理解できなくて当然。

Javaでは、Abstract Class, Abstract methodで登場するキーワード。

# Inheritanceの忍対戦の問題を考えてみよう
Shinobiを体術忍、幻術忍が継承し、それぞれをnewを利用してロック・リー、クレナイを生成した。

Shinobi自体は利用する想定がなかったので、ダメージも0にしてた。

これをみた人が、「イタチは最強だから、体術も幻術もできるように作ろう！」と思って

```java
Shinobi UchihaItachi = new Shinobi();
```

のような書き方をしてしまった。このイタチは可哀想にも絶対勝てない。

ShinobiクラスがAbstract Classだったら、大丈夫だった。


その人はまた、「あかつきというクラスを作ろう！」と思って

```java
public class Akatsuki extends Shinobi {
    ...
}
```
を書いたが、忘れて奥義をOverrideするの忘れちゃった！

奥義しても何で攻撃したか全くわからなくなってしまった。

ougiがAbstract methodだったら大丈夫だった。

# Abstract Class
extendsには使えるけど、newには使えないクラス。

親クラスの「概念」はあるから親クラスとしてまとめたいけど、

実際のインスタンスが作れたら行けない場合使う。

# Abstract Method
思ったより人間はおろかであり、忘れがち。

「このクラスをExtendしたいなら、このMethodはOverrideしないと行けません！」

と説明書に書いてても、そんなの誰も読まない。

![世界共通](https://i.redd.it/2z08tsdqms011.jpg)
*世界共通*

ライブラリーのソースコードを直接読むこともできないし、

もし必須でOverrideすべきMethodがPrivateで、ロジックの奥に隠れてたら？

それを防ぐため、「このクラスを継承した以上、このメソッドは書くべき！」とわかるよう、

メソッドの前にabstractキーワードつけて「Abstract Method」を「宣言」する必要がある。

# ややこしいところ
**abstract methodはabstract classだけ持てる。**

インスタンス化防ぎたいときだけではなく、

abstract methodをもたせたい場合もabstract classを利用する必要になる。

**だが、abstract classがabstract methodを必ず持つ必要はない**

だから、「abstract classは作ったけど、どのMethodをabstractにするんだ？」って悩みは不要。
