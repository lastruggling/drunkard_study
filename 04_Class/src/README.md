# Class
みんなの最初のやま、Class

イマイチ理解できないなら、経験上「俺が定義した変数タイプ」の説明で理解できた後輩多かった

変数を使うときを考えたら
```java
// Declaration
int a;
// Initialization
a = 100;
```
このようにしてる。Classの場合だと

```java
// Declaration
MyClass myClass = new Class();
// Initialization, Assignment
myClass.member = 100;
```
似てる。

ちなみに、ClassはMyClassで、myClassがInstance, Objectである。

Objectという基本クラスがあるから、インスタンスっていう表現を使いましょう。


# Public/Private
Class内部だけで操作できるか否かのこと。

Protectedたるものもあるけど、それはInheritanceのあとのもの