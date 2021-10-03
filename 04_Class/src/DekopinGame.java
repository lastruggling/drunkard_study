import java.util.Random;

public class DekopinGame {
    public static void main(String[] args) {
        Player player1 = new Player("Konan");
        Player player2 = new Player("Naruto");

        System.out.println("Game Start");
        while(player1.getHP() > 0 && player2.getHP() > 0) {
            play(player1, player2);
            showHP(player1, player2);
        }
    }

    public static void showHP(Player p1, Player p2) {
        System.out.println("HP of " + p1.getName() + ": " + p1.getHP());
        System.out.println("HP of " + p2.getName() + ": " + p2.getHP());
    }

    public static void play(Player left, Player right) {
        int leftPoint = left.rollDice();
        int rightPoint = right.rollDice();

        System.out.println("Dice number of " + left.getName() + ": " + leftPoint);
        System.out.println("Dice number of " + right.getName() + ": " + rightPoint);

        if(leftPoint > rightPoint) {
            System.out.println(left.getName() + " Won!");
            left.hit(right);
        } else {
            System.out.println(right.getName() + " Won!");
            right.hit(left);
        }
    }
}

class Player {
    private String name;
    private int HP;
    private Random dice;

    public Player(String name) {
        this.name = name;
        this.HP = 100;
        this.dice = new Random();
    }

    public String getName() {
        return this.name;
    }

    public int getHP() {
        return this.HP;
    }

    public int rollDice() {
        return this.dice.nextInt(6) + 1;
    }

    private void damage(int damage) {
        this.HP -= damage;
        if(this.HP < 0) {
            this.HP = 0;
        }
    }

    // 注目ポイント
    // enemyは同じクラスだけど、違うインスタンス(player1, player2は同じインスタンスじゃない)
    // でも、enemyのprivateが利用できる。
    // 同じClass同士ではPrivateにアクセスできること。
    public void hit(Player enemy) {
        System.out.println(this.name + "hits " + enemy.name);
        enemy.damage(10);
    }
}