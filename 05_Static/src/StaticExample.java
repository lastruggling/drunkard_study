public class StaticExample {
    public static void main(String[] args) {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();

        // Classから直接Memberアクセス
        System.out.println(MyClass.staticString);
        // System.out.println(MyClass.instanceString); //Error

        // InstanceからMemberアクセス
        // Intellij, Eclipseとかから「StaticをInstanceからアクセスしてるよ-」とメッセージ出てるはず
        System.out.println(myClass1.staticString);
        System.out.println(myClass1.instanceString);

        // ClassからMethod呼び出し
        MyClass.printStaticString();
        // MyClass.printInstanceString(); //Error

        // InstanceからMethod呼び出し
        myClass1.printStaticString();
        myClass1.printInstanceString();

        // ClassからStatic Stringを修正して確認
        // myClass1, myClass2のstaticStringはいじってないのに修正されてる
        MyClass.staticString = "Changed Static String via Class";
        System.out.println(MyClass.staticString);
        System.out.println(myClass1.staticString);
        System.out.println(myClass2.staticString);

        // InstanceからStatic String修正
        // MyClass、myClass2のStatic Stringはいじってないのに修正されてる
        myClass1.staticString = "Changed Static String via Instance";
        System.out.println(MyClass.staticString);
        System.out.println(myClass1.staticString);
        System.out.println(myClass2.staticString);

        // ClassからInstanceStringを修正するのはできない
        //MyClass.instanceString = "Changed Instance String via Class";

        // InstanceからInstance String修正
        // 当然にもmyClass1のInstance Stringだけ修正されてる
        myClass1.instanceString = "Changed Instance String via Instance";
        //System.out.println(MyClass.instanceString); //Error
        System.out.println(myClass1.instanceString);
        System.out.println(myClass2.instanceString);
    }
}

class MyClass {
    static String staticString = "This is Static String";
    String instanceString = "This is Instance String";

    static void printStaticString() {
        System.out.println("Printed by Static Method");
    }

    void printInstanceString() {
        System.out.println("Printed by Instance Method");
    }
}