# Package
本とかで後ろに「Package」と名付けて出るから難しく見えるけど、

勉強する対象でもないくらいの話。

名前通り、「まとめる」だけ。何を？コードを。

ディレクトリに似たようなコードをまとめること。

CやPHPのinclude、C++だとnamespace、VisualBasic.NETだとDimみたいなもの。

Javaはディレクトリー基盤である。

# 生成方法
コードの一番上にpackage名を入れて、それに従ったディレクトリーに配置させる

とかもあるけど、今どきにはみんなそれぞれのIDEを利用してると思うけど、

追加したいディレクトリーで右クリックすると、Add Packageとかがあるはず。

Eclipseでも、IntelliJでも。

それがないIDEがもしあれば使わないほうがいいかも。

パッケージ名には_や数字で始めないなど規則があるけど、ほぼ小文字だけでやってるから一旦そんな感覚でいい。

気になればググってみましょう。

# 他パッケージのクラスを利用する方法
クラス名の前にパッケージ名をつけて全部入れて利用すればいい。

```java
java.util.Scanner sc = new java.util.Scanner();
```

「うん？そんなことしてなかったけどちゃんと動いたよ？」と思ったら、正解。

頻繁に使うパッケージのクラスは、クラス名だけで利用できるようにするのがimport。

**Package利用するためにはimportが必須ではない。**

**いちいちパッケージ名を入れるのがめんどいとき、importしてしまおう**

の接近がわかりやすいかもね。

ちなみに、パッケージとクラス名全部含めたのをFQCN(Fully Qualified Class Name)という。

# Compileは？実行は？
IDE利用してたら、Runとかで自動的に実行できるけど、

例で書いたソースコードを一回は手書きでやってみましょう。(Window, Mac, Linuxによって違うかも)

1. 10_package\srcで実行
```bash
10_package/src$ javac main/MainExample.java
10_package/src$ java main.MainExample
```
はい、成功ー

2. 10_packageで実行
```bash
10_package$ javac -cp src/ src/main/MainExample.java
10_package$ java -cp src/ main.MainExample
```
-cpはまた何だ？

# 実は理論的な話が必要
cpはClasspathの略で、javacとjava実行時に「クラスパスはここだよー」の意味。

Classpathは「クラスの経路」の意味。

「Javaではパッケージをディレクトリで管理する」とか話が出てたよね。

ざっくりと言うと、import書くとき(もしくはFQCN)、subから記入してる。

10_package/srcかれComplieすると、Compilerがソースコードを読んで

「実行した今のパス(src)の配下、subの配下、firstの配下、FirstSubExample」を探してCompileし、

最後にMainをコンパイルしてくれる。

※**ここ微妙なのが、実はJavaファイルごとCompileする必要があったかもしれない。**<br>
https://stackoverflow.com/questions/8027670/compiling-four-java-files-within-one-package-using-javac/8027719<br>
**10年ぐらい前のないようだと、「Importされるクラスを先にCompileしとけ」と書いてる。**

だが、srcの上からやると
```bash
10_package$ javac src/main/MainExample.java
src/main/MainExample.java:2: error: package sub.first does not exist
import sub.first.FirstSubExample;
                ^
src/main/MainExample.java:3: error: package sub.second does not exist
import sub.second.SecondSubExample;
                 ^
src/main/MainExample.java:6: error: package sub.first does not exist
import sub.first.SubExample;
                ^
src/main/MainExample.java:11: error: cannot find symbol
        FirstSubExample firstSubExample = new FirstSubExample();
        ^
  symbol:   class FirstSubExample
  location: class MainExample
src/main/MainExample.java:11: error: cannot find symbol
        FirstSubExample firstSubExample = new FirstSubExample();
                                              ^
  symbol:   class FirstSubExample
  location: class MainExample
src/main/MainExample.java:14: error: cannot find symbol
        SecondSubExample secondSubExample = new SecondSubExample();
        ^
  symbol:   class SecondSubExample
  location: class MainExample
src/main/MainExample.java:14: error: cannot find symbol
        SecondSubExample secondSubExample = new SecondSubExample();
                                                ^
  symbol:   class SecondSubExample
  location: class MainExample
src/main/MainExample.java:17: error: cannot find symbol
        SubExample subExample1 = new SubExample();
        ^
  symbol:   class SubExample
  location: class MainExample
src/main/MainExample.java:17: error: cannot find symbol
        SubExample subExample1 = new SubExample();
                                     ^
  symbol:   class SubExample
  location: class MainExample
src/main/MainExample.java:22: error: package sub.second does not exist
        sub.second.SubExample subExample2 = new sub.second.SubExample();
                  ^
src/main/MainExample.java:22: error: package sub.second does not exist
        sub.second.SubExample subExample2 = new sub.second.SubExample();
                                                          ^
11 errors
```
「そんなクラス探せませんが」とエラーを吐き出す。

Compilerは「今実行するディレクトリ(Path)がどこ」かを分からず、

import句をみて`10_package\sub\first\`を探そうとして失敗してしまう。

そのために、Compilerに「Compileせよ。クラスとか探すとき基準になるパスはここよ」とsrcを指名して上げる必要がある。

java実行時も同じ。「実行の再、クラス探すときはここを探してよー」

# 複数のClasspathを指定するとき、Windowsは「；」Linuxは「：」
jar(Java Archive)って、見たことある？

他人が作ったJavaライブラリーとかを使うときでは、「このjarを入れて」の話がある。

その場合では、Classpathにjarの経路を設定する必要がある。

もちろん、jarがでる場面で手でCompileすることはないだろうけど、

**複数のClasspathを設定する必要があるときがある。**

そういうときは；か：区切りで全部入れればOK。

「今使うべきって、どっちだっけ。。。」と思ったら、java -hで探してみよう

Linuxだと
```bash
$ java -h
...
    -cp <class search path of directories and zip/jar files>
    -classpath <class search path of directories and zip/jar files>
    --class-path <class search path of directories and zip/jar files>
                  A : separated list of directories, JAR archives,
                  and ZIP archives to search for class files.
...
```

PowerShellだと
```
PS C:\Users\lastr> java -h
    -cp <class search path of directories and zip/jar files>
    -classpath <class search path of directories and zip/jar files>
    --class-path <class search path of directories and zip/jar files>
                  A ; separated list of directories, JAR archives,
                  and ZIP archives to search for class files.
```

困ったときにはこういうのもあるってことが言いたかっただけ。
