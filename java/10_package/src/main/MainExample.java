package main;
import sub.first.FirstSubExample;
import sub.second.SecondSubExample;

// ここで、second.SubExampleをimportすると、2行目の出力が変わる
import sub.first.SubExample;
//import sub.second.SubExample;

public class MainExample {
    public static void main(String[] args) {
        FirstSubExample firstSubExample = new FirstSubExample();
        firstSubExample.execute();

        SecondSubExample secondSubExample = new SecondSubExample();
        secondSubExample.execute();

        SubExample subExample1 = new SubExample();
        subExample1.execute();

        // クラス名がかぶってしまった場合は
        // importせず、こんな漢字でパッケージ名を全部入れるのも可能
        sub.second.SubExample subExample2 = new sub.second.SubExample();
        subExample2.execute();
    }
}
