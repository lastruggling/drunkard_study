# Interface
辞書的な意味は様々あって、一体何か？というぐらいふわっとしてる言葉。

Javaの本、誰かのブログ、特に韓国では説明がよくある

「全てのメソッドがabstractであるクラスのようなもの」

であれば、Abstract classだけでいいのに、また変なの作った理由はなぜ？

こんなものがあった

https://www.internetacademy.jp/it/programming/java/difference-between-interface-and-abstract.html

# ClassとInheritanceに戻ってみましょう
「Extendsは共通のものであり、Interfaceは制約や契約に近い」とかの、ふんわりした表現はあとにして。

**「クラスの継承は一つだけからできる」**

ということがある(ちなみに、C++では複数のクラスから継承できる。教授からは「使うな」レベルだったけど)

個人的に、身近で感じるInterfaceの理由はこれである。

忍対戦はうんざりだと思うから、ワンピースにしましょう。

## ルフィーが作れない
たとえ、登場人物それぞれをクラスに作ろうとしたら
```java
abstract class DevilFruitPirate{
    boolean isSwimmable = false;
    abstract String Ability();
}

abstract class HakiPirate{
    boolean isSwimmable;
    abstract String Haki();
}
```
悪魔の実の能力者、覇気能力者それぞれを抽象クラスにして起きましょう。
```java
class Zoro extends HakiPirate{ }

class Buggy extends DevilFruitPrivate{ }
```
これぞれ一つの特徴をもったゾロとバギーは作れるけど

```java
// Compileできないよ
class Luffy extends HakiPirate, DevilFruitPrivate{}
}
```
Luffyは作れない。

ゾロの三刀流が通じなくて、べギーが海賊王になる最悪な漫画になってしまう。

## Interfaceにしてルフィーを作ろう
Interfaceにすれば、こんなのができる
```java
public interface Haki{}

public interface DevilFruit{}

class Zoro implements Haki{}

class Buggy implements DevilFruit{}

class Luffy implements Haki, DevilFruit{}
```

「このクラスは、このInterfaceをImplementする」

Extendsとはまた違う使い方をしてる。

# 結局、属性ではないかな
厳密に言うと間違うが、

**「クラスが持ちたい属性がInterfaceで、 その属性を持つため必須であるメソッドの名前を書いたもの。」**

これが個人的な考え方。

「覇気をまとった」Interfaceには、それが覇王色か武装色か決めるメソッドが必須とか、

「悪魔の実を食べた」Interfaceには、能力が何なのかを決めるメソッドとか。

必須である必要があるため、「契約」という言葉も出る。

「このInterfaceを利用したいなら、**これくらいは書けよ。厳守！**」

Classの場合は、「結局同じものだけど、それにもうちょっと追加してるものよ」の関係。 

これをOOP用語で「**Is-A Relationship**」という。

契約と言える良い事例がまたあった。

https://stackoverflow.com/a/3597910

```
空軍にいた時、俺はパイロット資格と取り、C-141パイロットでした。
追加の義務で安全委員の資格を取る必要もありました。

Abstract classはパイロット
ClassはC-141パイロット
Interfaceは安全委員
```

# 今はぐっと来なくていい
これ理解できない人は、世の中山程いる。

Abstract classとInterfaceで検索したら質問も多い、資料も多い。

このあとに出るArrayListのコードを見ればなんとなくわかるかも。
