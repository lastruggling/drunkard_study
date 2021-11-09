import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



interface Vehicle {
    // Java8からはInterfaceにてMethod定義可能
    // Implementするとき書かなくてもいい
    // keyword : default method、Lambda
    default String which() {
        // 現在のクラス
        return this.getClass().getSimpleName();
    }

    void stop();
    void run();
}

class Bike implements Vehicle {
    @Override
    public void stop() {
        System.out.println("ブレーキ引っ張ってストップ");
    }

    @Override
    public void run() {
        System.out.println("2輪で走る");
    }
}

class Car implements Vehicle {
    @Override
    public void stop() {
        System.out.println("ブレーキ踏んでストップ");
    }

    @Override
    public void run() {
        System.out.println("4輪で走る");
    }
}

class Runner {
    public void stop() {
        System.out.println("足止める");
    }

    public void run() {
        System.out.println("走る");
    }
}

// VehicleをImplementしたクラスのみ利用できる
// Tを制限するのをBoundと言う
class Riders<T extends Vehicle> {
    // Polymorphismだな
    List<T> riders = new ArrayList<>();

    public void add(T t) {
        this.riders.add(t);
    }

    public void printByFor() {
        System.out.println("Members Classes By For");
        for(T rider : riders) {
            // このクラスのTは、VehicleからExtendしてると明示してるからwhichというメソッド使える
            System.out.println(rider.which());
        }
    }

    // Iteratorというのを利用するのも可能
    // これもまたGenericだよね
    public void printByIterator() {
        System.out.println("Members Classes By Iterator");
        Iterator<T> it = this.riders.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().which());
        }
    }

    // RunはIteratorでやってみましょう
    public void run() {
        System.out.println("Run All Vehicles!");
        Iterator<T> it = this.riders.iterator();
        while(it.hasNext()) {
            it.next().run();
        }
    }

    // StopはForでやってみましょう
    public void stop() {
        System.out.println("Stop All Vehicles!");
        for(T rider : riders) {
            rider.stop();
        }
    }
}

// 複数のClassをBoundする
class Runners<T> {
    List<T> runners = new ArrayList<>();

    public void add(T t) {
        this.runners.add(t);
    }

    // 簡単にForだけ実装
    public void printByFor() {
        System.out.println("Members Classes");
        for(T runner : runners) {
            // ここのTは、Runnerも入れるためwhichがあるとは限らない
            //System.out.println(runner.which());
            System.out.println(runner.getClass().getSimpleName());
        }
    }
}

public class GenericExample {
    public static void main(String[] args) {
        Riders<Vehicle> riders = new Riders<>();
        riders.add(new Bike());
        riders.add(new Car());
        riders.run();
        riders.stop();
        riders.printByFor();
        riders.printByIterator();

        // Compile Error
        //riders.add(new Runner());

        // Runnersには何でも入れる
        Runners<Object> runners = new Runners<>();
        runners.add(new Runner());
        runners.add(new Bike());
        runners.add(new Car());
        runners.printByFor();

        // 明示的に、＜＞の中にタイプを書いてもエラーなし
        GenericExample.<Runner>run(new Runner());
        GenericExample.<Vehicle>run(new Bike());
        GenericExample.<Vehicle>run(new Car());

        // ＜＞を書かなくても、パラメーターに入ってるタイプを見て予測してくれる
        // メソッド名が一緒でも！
        // Overloading的なものかな
        GenericExample.run(new Runner());
        GenericExample.run(new Bike());
        GenericExample.run(new Car());
    }

    // Generic Methodももちろん可能
    // 厳密には設計失敗ケースだけど、Generic Methodが可能ってことを見せるため書いた事例
    public static <T extends Runner> void run(T t) {
        t.run();
    }

    public static <T extends Vehicle> void run(T t) {
        t.run();
    }
}