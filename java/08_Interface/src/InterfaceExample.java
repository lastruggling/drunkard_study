public class InterfaceExample {
    public static void main(String[] args) {
        HakiPirate ZoroByClass = new ZoroClass();
        DevilFruitPirate BuggyByClass = new BuggyClass();
        // ルフィーはできないよ

        System.out.println(ZoroByClass.printHaki());
        System.out.println(BuggyByClass.printFruit());

        // ここまで見たらAbstractClassと差分ない
        // 同じく、Interface変数にnewするの可能
        Haki ZoroByInterface = new ZoroInterface();
        DevilFruit BuggyByInterface = new BuggyInterface();
        System.out.println(ZoroByInterface.printHaki());
        System.out.println(BuggyByInterface.printFruit());

        // Luffyは、HakiでもDevilFruitとしても作れる
        Haki LuffyByHakiInterface = new LuffyInterface();
        DevilFruit LuffyByDevilFruitInterface = new LuffyInterface();

        // 実行は、それぞれInstanceのタイプによって違う
        // HakiInterfaceとして作られたインスタンス、LuffyByHakiInterfaceはPrintFruitはできない
        System.out.println(LuffyByHakiInterface.printHaki());
        //System.out.println(LuffyByHakiInterface.printFruit());

        // 同じく、DevilFruitInterfaceとして作られたインスタンスは、Hakiはかけない
        //System.out.println(LuffyByHakiInterface.printFruit());
        System.out.println(LuffyByDevilFruitInterface.printFruit());

        // これで一つわかるのは「このインスタンスはなにか」を決めるのは、
        // どのConstructorで作ったかではなく、インスタンス変数のタイプであるのがわかるかな？
        // ZoroClassに新しいメソッドを追加して、ZoroByClassから読んでみよう！
    }
}

abstract class HakiPirate {
    abstract String printHaki();
}

abstract class DevilFruitPirate {
    abstract String printFruit();
}

class ZoroClass extends HakiPirate {
    @Override
    String printHaki() {
        return "武装色の覇気";
    }
}

class BuggyClass extends DevilFruitPirate {
    @Override
    String printFruit() {
        return "バラバラの実！";
    }
}

/* できないよ
class LuffyClass extends HakiPirate, DevilFruitPirate {
    @Override
    String printHaki() {
        return "覇王色の覇気！";
    }

    @Override
    String printFruit() {
        return "ゴムゴムの実！";
    }
}
*/

interface Haki {
    String printHaki();
}

interface DevilFruit {
    String printFruit();
}

class ZoroInterface implements Haki {
    @Override
    public String printHaki() {
        return "武装色の覇気！";
    }
}

class BuggyInterface implements DevilFruit {
    @Override
    public String printFruit() {
        return "バラバラの実！";
    }
}

class LuffyInterface implements Haki, DevilFruit {
    @Override
    public String printHaki() {
        return "覇王色の覇気！";
    }

    @Override
    public String printFruit() {
        return "ゴムゴムの実！";
    }
}