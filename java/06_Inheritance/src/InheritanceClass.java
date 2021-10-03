import java.util.Random;

public class InheritanceClass {
    public static void main(String[] args) {
        // Mainでは、ゲームの実行するところを持ってるだけ
        // 言葉変えると、「メインはアプリケーションの発火するだけ」
        ShinobiTaisen game = new ShinobiTaisen();
        game.play();
    }
}

// ゲーム自体もオブジェとして扱うのがOOP
class ShinobiTaisen {
    // ロックリーは、しのびであり体術忍
    Shinobi rocklee = new TaisyutsuNin();
    // くらないは、幻術忍びえたり巨乳
    Shinobi kurenai = new GensyutsuNin();
    // 注目点としては、変数前のやつとnew後のやつが一致してないこと！
    // これは、「体術忍でも、現塾忍でも、忍だよ」の理解でいい

    public void play() {
        while(!(rocklee.isKnockOut() || kurenai.isKnockOut())) {
            if(rocklee.rollDice() > kurenai.rollDice()) {
                rocklee.ougi(kurenai);
            }
            else {
                kurenai.ougi(rocklee);
            }
        }
        this.printStatus(rocklee, kurenai);
    }

    public void printStatus(Shinobi shinobi1, Shinobi shinobi2) {
        System.out.println("Player 1 Status");
        System.out.println("HP : " + shinobi1.hp + " Chakra : " + shinobi1.chakra);
        System.out.println("Player 2 Status");
        System.out.println("HP : " + shinobi2.hp + " Chakra : " + shinobi2.chakra);
    }
}

class Shinobi{
    int hp;
    int chakra;
    int ougiHpDamage;
    int ougiChakraDamage;

    public Shinobi() {
        this.ougiHpDamage = 0;
        this.ougiChakraDamage = 0;
    }

    // 忍なら誰でもサイコロは回す
    public int rollDice() {
        Random rd = new Random();
        return rd.nextInt(6) + 1;
    }

    // 忍誰でも奥義は持ってる
    // ただ、自分が持ってる能力でenemyに与えるダメージがちがう
    public void ougi(Shinobi enemy){
        enemy.hp -= this.ougiHpDamage;
        enemy.chakra -= this.ougiChakraDamage;
        System.out.println("相手のStatus");
        System.out.println("HP : " + enemy.hp + " Chakra : " + enemy.chakra);
    }

    protected boolean isKnockOut() {
        return (this.hp <= 0 || this.chakra <= 0);
    }
}

// 体術忍びでも、忍びではある
class TaisyutsuNin extends Shinobi{
    public TaisyutsuNin() {
        // 体術忍は、HPとチャクラが違うし
        // 奥義のダメージも違うね
        this.hp = 200;
        this.chakra = 100;
        this.ougiHpDamage = 0;
        this.ougiChakraDamage = 10;
    }

    // 忍びなら誰でも持ったる奥義だが、殴るからコメントが違う
    @Override
    public void ougi(Shinobi enemy) {
        System.out.println("体術でなぐった！");
        super.ougi(enemy);
    }
}

// 幻術忍びも、忍
class GensyutsuNin extends Shinobi{
    public GensyutsuNin() {
        // 幻術系の忍は、HPもチャクラも違う
        // もちろん奥義のダメージもちがう
        this.hp = 100;
        this.chakra = 200;
        this.ougiHpDamage = 0;
        this.ougiChakraDamage = 10;
    }

    // 忍びなら誰でも持ったる奥義だが、メンタルいじるからコメント違う
    @Override
    public void ougi(Shinobi enemy) {
        System.out.println("幻術でメンタルいじり！");
        super.ougi(enemy);
    }
}
