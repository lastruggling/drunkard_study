// javaはプログラム自体もクラス
// ファイル名とクラス名が違うとCompileができなくなる経験あるはず
// Compileしたら、ファイル名.classというファイルが出るの考えると、
// ファイル実行する時「ファイル名と同じ名前のクラスを探す」ものだろう
public class ClassExample {
    public static void main(String[] args) {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass("Construction Input");

        myClass1.print();
        myClass2.print();

        myClass1.publicString = "Changed public string";
        //Privateだからいじれないよ
        //myClass1.privateString = "Cannot change private member";
        myClass1.setPrivateString("Change private string");
        //Privateだから、実行できないよ
        //myClass1.printPrivate();

        myClass1.print();

        System.out.println(myClass2.publicString);
        //System.out.println(myClass2.privateString);
        System.out.println(myClass2.getPrivateString());

        EmptyClass emptyClass = new EmptyClass();
        // Default Constructorが自動的に生成されるけど、どうすればいいからDefault値が入ってる
        // publicIntは、単純変数だから0
        System.out.println(emptyClass.publicInt);
        // Class化されてるIntegerは、Objectだからnull
        System.out.println(emptyClass.publicIntegerObject);
    }
}

// Classは、「自分が定義した新しい変数のType」って考え方がわかりやすいかも
class MyClass {
    // Classが持ってる変数
    // Memberと言う

    // publicは「公」、Class内部ではなくても操作ができる
    public String publicString;
    // privateは「個人の」、Class内部ではないと操作できない
    // 操作するためには、「裏口」的に共用する必要がある
    private String privateString;

    // Constructorという
    // Class名と同じ名前のMethodみたいに書く
    public MyClass() {
        // thisは、「今実行されてるObject」のこと
        // Main見ると、myClass1, myClass2があるけど、
        // それぞれが持ってるmemberをいじりたい時、thisを使う
        this.publicString = "This is public string";
        this.privateString = "This is private string";
    }

    // パラメーター入れて初期値を入れるのも可能
    public MyClass(String initInput) {
        this.publicString = initInput + " Public";
        this.privateString = initInput + " Private";
    }

    // Privateのmemberは、窓口を開けるように
    // Publicな関数を経由して操作する必要がある
    // 通常Getter/Setterと言うけど、大したことなく窓口役のメソッドのこと
    public String getPrivateString() {
        return privateString;
    }
    public void setPrivateString(String input) {
        this.privateString = input;
    }

    // このClassのメソッド
    // publicだからClassの外から実行できる
    public void print() {
        System.out.println(this.publicString);
        System.out.println(this.privateString);
        this.printPrivate();
    }

    // privateだから、このClassの中だけで実行できる
    private void printPrivate() {
        System.out.println("Private Print");
    }
}

// Constructorがないやつ
// なんでObject生成ができるかな？
// ヒントは「Default Constructor」
class EmptyClass {
    // 変数話す時、Wrapperとかあると話したけど
    // Java作った人がClass化してるってこと
    public int publicInt;
    public Integer publicIntegerObject;
}