# Genericとは？
「一般的な」の意味。何が？

JavaでGenericというと、「Classに関係なく、一般的なものに対応できる」かな

実はArrayListで一回は出たやつ。

Java1.5から提供した昨日。またなんで追加したのだろ？

# Polymorphism的にカバーはできるけど。。。
実は、Javaの全てのクラスはObjectというクラスから継承してる。

String, Integerみたいにjava.langから基本的に含まれたクラスでも、

自分で作ったクラスでも。

なので、凡庸的に対応するクラスを作りたかったら、Objectタイプを利用すればできる。

## でもそれがくそめんどいのよ
```java
class Box() {
    Object object;
    
    public Box(Object input){
        this.object = input;
    }
    
    public Object getStuff() {
        return this.object;
    }
}
```

## 問題はこれから
Boxを利用して凡庸的なコードを作成してみようとした
```java
public static void main(String[]args){
    Box stringBox = new Box("String");
    String stringFromBox = (String)stringBox.getStuff();
    
    Box intBox = new Box(10);
    Integer intFromBox = (Integer)intBox.getStuff();
}
```
利用するためにはType castが必要であり、逆に面倒くさくなった。

更に、Boxの配列を利用するとしてみよう。
```java
public static void main(String[]args){
    // 数字のBoxだけ入れる配列を作ろう
    Box[] boxArray = new Box[2]; 
    Box intBox = new Box(10);
    boxArray[0] = intBox;
    
    ...
    // コードが長くなって、boxArrayがなんのためのBoxを入れるべきか忘れた
    Box strBox = new Box("string");
    boxArray[1] = intBox;
    
    ...
    // 数字だけ入ってると思って、かけ演算をしちゃう
    return boxArray[0] * boxArray[1];
}
```
パット見てもこれはまずくてCompileできなさそうだけど、Compileはできちゃう。

こういうコードがあり、他のパッケージに入ってわるさをするとしたら、

コードをいちいち見ないとわからなくなるね

# すでに見たことあるGeneric
ArrayListをいじってみるとき、＜＞を見たことがあるはず
```java
ArrayList<Integer> intArrayList = new ArrayList<>();
```
ArrayListは何も入れれる凡庸的なものとして作られてるけど、

上のようにちゃんとIntegerだけ入れるようにしてる。

これは、Integer用のArrayListと、String用のArrayListを別に作ったわけではなく、

Genericを利用したものだ。

(Java1.5以前のArrayListの使い方が気になって探して見たかったけど、探せず)

# ＜＞で囲むだけ
一見複雑に見えるけど、 「どのタイプが入るかわからないから、仮にしといたよ」を明示するだけ。

「仮だよ」の印が＜＞に過ぎない。

借りだから何でもいいけど、一旦世間的に決めたルールはあるね

    E - Element (used extensively by the Java Collections Framework)
    K - Key
    N - Number
    T - Type
    V - Value
    S,U,V etc. - 2nd, 3rd, 4th types

https://docs.oracle.com/javase/tutorial/java/generics/types.html

# Interfaceとの組み合わせが楽なのよ
「何が入るかわからないけど、こんな機能があるのは確実なクラスが入るよ」

とかは、Interfaceを利用するとできるよね

```java
import java.util.ArrayList;

interface Gamble {
    void lose();
}

class Majon implements Gamble {
    void lose() {
        System.out.println("国士無双にぼろ負け");
    }
}

class Poker implements Gamble {
    void lose() {
        System.out.println("ロイヤルストレートフラッシュにぼろ負け");
    }
}

public class Gambler {
    public static void main(String[] args) {
        ArrayList<Gamble> gambleList = new ArrayList<>();
        
        gambleList.add(new Majon());
        gambleList.add(new Poker());
        
        for(Gamble gamble: gambleList) {
            gamble.lose();
        }
    }
}
```
もちろん親クラスを利用するのも可能だろう。

# 一瞬ArrayListにもどると
APIの話するとき、ArrayListとArrayの差分で

`ArrayList<int>はできないね`とか話あったけど、それもGenericに関係ある。

Genericに利用できるのはClassに限るから、intみたいなPrimitive Typeは使えない。

なぜClassに限るかというと、

**裏では上に書いた、全てObjectにするようにしてるから。**

**Objectから継承してないPrimitive Typeは使えない。**

https://stackoverflow.com/questions/2721546/why-dont-java-generics-support-primitive-types

# 興味があれば
Genericを利用したクラスを自分で作成するのは、いまいまではあまりないと思うけど

いざそうなったときには

https://docs.oracle.com/javase/tutorial/java/generics/index.html

https://www.baeldung.com/java-generics

こういうの見るほうがいいかと
