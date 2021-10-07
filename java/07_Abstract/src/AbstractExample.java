import java.util.Random;

public class AbstractExample{
    public static void main(String[] args) {
        // ガイ先生は、しのびであり体術忍
        Shinobi mightGuy = new TaijyutsuShinobi("Might Guy", 500, 100);
        // イタチは一旦幻術にしとこ
        Shinobi itachi = new GenjyutsuShinobi("Uchiha Itachi", 200, 500);
        // なるとの遺産着服したさるとびはインスタンス化されない
        //Shinobi sarutobi = new Shinobi("Sarutobi", 1, 1);

        mightGuy.setDamageBound(20, 50);
        itachi.setDamageBound(10, 30);

        ShinobiTaisen taisen = new ShinobiTaisen(mightGuy, itachi);
        Shinobi winner = taisen.play();

        System.out.println("Winner : " + winner.name);
    }
}

abstract class Shinobi {
    protected String name;
    protected int hp;
    protected int chakra;
    protected int lowerBound;
    protected int upperBound;
    // ダメージをランダムにするとしたら
    // ダメージもShinobiの属性だから、ここに持たせたほうが
    // Methodの中で生成してもいいけど、呼ばれるたびに生成されるのメモリ的に嫌だね
    protected Random damageGenerator = new Random();

    public Shinobi(String name, int hp, int chakra) {
        this.name = name;
        this.hp = hp;
        this.chakra = chakra;
    }

    public String getName() {
        return name;
    }

    public void setDamageBound(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public int getChakra() {
        return this.chakra;
    }

    public void setChakra(int chakra) {
        this.chakra = chakra < 0 ? 0 : chakra;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp < 0 ? 0 : hp;
    }

    // この汚いロジックはなんでしょー
    public int getDamage() {
        return damageGenerator.nextInt(this.upperBound - this.lowerBound) + this.lowerBound + 1;
    }

    abstract void ougi(Shinobi enemy);

    protected boolean isKnockOut() {
        return (this.hp <= 0 || this.chakra <= 0);
    }
}

// ClassがなんかきれいになったけどそれはAbstractの影響ではなくRefactoringや設計の影響
class TaijyutsuShinobi extends Shinobi{
    // ougiを削除したり、Constructorを追加してみたり
    // 色々遊んでみてどの場合どのエラーが出るか確認しましょう
    public TaijyutsuShinobi(String name, int hp, int chakra) {
        super(name, hp, chakra);
    }

    @Override
    public void ougi(Shinobi enemy) {
        System.out.println("体術でなぐる！");
        int damage = this.getDamage();
        System.out.println("Damage : " + damage);
        // ここなんかきれいにできそうだな
        enemy.setHp(enemy.getHp() - damage);
    }
}

class GenjyutsuShinobi extends Shinobi{
    // ExtendsするたびにConstructorでsuper書くのもめんどいから
    // SuperclassはDefault Constructorにして
    // 全部Getter/Setterにしちゃっていいかも
    public GenjyutsuShinobi(String name, int hp, int chakra) {
        super(name, hp, chakra);
    }
    @Override
    public void ougi(Shinobi enemy) {
        System.out.println("幻術でメンタルいじり！");
        int damage = this.getDamage();
        System.out.println("Damage : " + damage);
        enemy.setChakra(enemy.getChakra() - damage);
    }
}

// ShinobiTaisenをClass化してたけど、前のものもハードコードだったから
// Playerはメインから渡してもらうようにした
class ShinobiTaisen {
    Shinobi player1;
    Shinobi player2;

    public ShinobiTaisen(Shinobi player1, Shinobi player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Shinobi play() {
        // このままだと1発ずつ交換する形になる
        // 同時に奥義使って、Loop終わる条件を一回だけ確認するのもありかな？
        while(true) {
            player1.ougi(player2);
            printStatus(player2);
            if(player2.isKnockOut()) return player1;
            player2.ougi(player1);
            printStatus(player1);
            if(player1.isKnockOut()) return player2;
        }
    }

    public void printStatus(Shinobi player) {
        System.out.println(player.getName() + " Status");
        System.out.println("HP : " + player.getHp() + " Chakra : " + player.getChakra());
        System.out.println();
    }
}
