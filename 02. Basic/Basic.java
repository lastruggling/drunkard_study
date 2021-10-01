public class Basic {
    public static void main(String[] args) {
        BasicVariables basicDefault = new BasicVariables();
        BasicVariables basicConstrucWithParams = new BasicVariables(true, 1);

        System.out.println(basicDefault.primitiveBoolean);
        System.out.println(basicDefault.objectBoolean);
        System.out.println(basicDefault.primitiveInteger);
        System.out.println(basicDefault.objectInteger);

        System.out.println(basicConstrucWithParams.primitiveBoolean);
        System.out.println(basicConstrucWithParams.objectBoolean);
        System.out.println(basicConstrucWithParams.primitiveInteger);
        System.out.println(basicConstrucWithParams.objectInteger);
    }
}

class BasicVariables {
    boolean primitiveBoolean;
    Boolean objectBoolean;
    int primitiveInteger;
    Integer objectInteger;

    // Constructorたるもんじゃ

    // Paramterが何もないと、通常「Default Constructor」という
    // ぐぐったらC++とか出てくるけど、色々探したらいいだろう
    // Java自体ではなくてもいいとか言うけど、実務でSpringとかになったら話違うから概念だけ覚えとこ
    public BasicVariables() {
        this.primitiveBoolean = false;
        this.objectBoolean = new Boolean(false);
        this.primitiveInteger = 0;
        this.objectInteger = new Integer(0);
    }

    // Object生成のタイミングで、初期値を入れるもの
    // 上から出てるthisは、「このオブジェの中の」の意味
    // これ理解できなかったらClass-Objectの説明を探して、自分なりの説明をしてみるのが宿題
    public BasicVariables(boolean inputBool, int inputInt) {
        this.primitiveBoolean = inputBool;
        this.objectBoolean = new Boolean(inputBool);
        this.primitiveInteger = inputInt;
        this.objectInteger = new Integer(inputInt);
    }
}