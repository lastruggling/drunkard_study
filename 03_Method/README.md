# Method
Function、関数とかと同じ。JavaではMethodという

厳密には、MethodとFunctionは違うけど、これはOOP的な概念が入ってるから。

一旦、「何かを入れて、操作して、何かを返すやつ」という本質は変わらない。

# static, publicとは？
これもObjectとかClassとかがあるから出てる概念。

# mainもメソッド
mainは、このファイルを実行する時最初に実行されるもの。

```
# Compileする
javac Method.java
# Compileしたものを実行
java Method
# このタイミングで、mainと書いてるところを実行する
```

なので、他のメソッドにmainと名付けるのはできないのだ

# Javascriptのような扱いができない
何かというと、JavascriptではFunction自体を変数みたいに使える

```
function add(a,b) {
    return a+b;
}
let sum = add;
console.log(sum(a, b));
```

これはJSだけできるもので、「Javascript First-class object」と検索すると出る。

個人的には「JSの根本なさ、変態さ」ぐらいに考えてる。

Javaではこういった使いをする必要がないし、おそらく書くこともないだろう。