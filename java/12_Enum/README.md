# enum
列挙型と言う。Enumerated Typeといい、自分で定数が定義したいとき使う。

定数を自分で定義する必要はあるのかな？

# こういうケースを考えましょう
食べ物のカロリーを表示するコードを考えましょう
```java
/*
1. りんご
2. もも
3. ばなな
 */
int type = 1;
switch(type) {
    case 1:
        System.out.println(57);
        break;
    case 2:
        System.out.println(34);
        break;
    case 3:
        System.out.println(93);
        break;
}
```
でも、1，2，3で表示するとわかりにくいね。コメント削除しちゃうと意味がわからなくなる。

であれば、finalを利用しちゃうのもあり

```java
private final static int APPLE = 1;
private final static int PEACH = 2;
private final static int BANANA = 3;
public static void main() {
    int type = APPLE;
    switch(type) {
        case APPLE:
            System.out.println(57);
            break;
        ...
}
```
これで大丈夫になったと思ったけど、急に会社を表示する必要が出てきた！

```java
//果物
private final static int APPLE = 1;
private final static int PEACH = 2;
private final static int BANANA = 3;

//会社
private final static int GOOGLE = 1;
private final static int TESLA = 2;
private final static int APPLE = 3;
public static void main() {
    int type = APPLE;
    switch(type) {
        case APPLE:
            System.out.println(57);
            break;
        ...
}
```
これだと、APPLEが重複しちゃうから、定義ができなくなる。

FRUIT_APPLE、COMPANE_APPLEみたいに接頭語を使ってもいいが、コードが長い。

何より問題は、
```java
if(FRUIT_APPLE == COMPANY_GOOGLE)
```
こんな話にならない条件がTrueになってしまう。

世の中、意外とアホが多くてこんなのも起きうるのよ。

# タイプ自体を分けちゃえば？
FRUITとCOMPANYをまたいだ比較を防ぐためなら、そもそも2つを違うクラスにする方法がある。
```java
class Fruit {
    public static final Fruit APPLE = new Fruit();
    public static final Fruit PEACH = new Fruit();
    public static final Fruit BANANA = new Fruit();
}

class Company {
    public static final Company GOOGLE = new Company();
    public static final Company TESLA = new Company();
    public static final Company APPLE = new Company();
}
```
Fruit, Companyそれぞれをクラスにして、

クラスが持てるバリエーションをStatic Instanceとしてもたせる。

これだとクラス中での比較もちゃんとできるし、クラスをまたいだ比較も防げる。

これはよく使えるね

# それがEnum
上のコードは、以下と一緒
```java
enum Fruit {
    APPLE, PEACH, BANANA;
}
enum Company {
    GOOGLE, TESLA, APPLE;
}
```
上のstatic final云々を、Java 1.5からEnumとして提供してる。

これで色々比較ができる楽な機能ですね？

はい、終わり！

# ちょっといじってみよう
enumも結局クラスの一種類ってことだから、Constructorもあるし、メソッドも持たせる。

上の事例だと、カロリー情報も持たせるし、出力もできる。

**データーとかを定数化して利用したい場合は**すごく便利だよね
