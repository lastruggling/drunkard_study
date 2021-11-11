enum Fruit {
    APPLE(57),
    PEACH(34),
    BANANA(93) {
        // Overrideも可能
        @Override
        public void shape() {
            System.out.println("Long");
        }
    };

    // private finalが必要。定数だから当然あら当然
    private final int calories;

    Fruit(int cal) {
        this.calories = cal;
    }

    public void printCalories() {
        System.out.println("Calories of " + this.name() + " : " + this.calories);
    }

    public void shape() {
        System.out.println("Round");
    }
}

public class EnumExample {
    public static void main(String[] args) {
        Fruit type = Fruit.APPLE;
        switch(type) {
            case APPLE:
                System.out.println("57 kcal");
                break;
            case PEACH:
                System.out.println("34 kcal");
                break;
            case BANANA:
                System.out.println("93 kcal");
                break;
        }

        // Fruitに定義したメソッド利用してみましょう
        // values()は、Enumの中にある要素を全部出してくれるEnumの機能かな？
        for(Fruit fruit : Fruit.values()) {
            fruit.printCalories();
            fruit.shape();
        }
    }
}
