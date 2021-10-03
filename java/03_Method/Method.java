public class Method {
    // メインもメソッドなのよ
    // public, staticとかは今は無視でいい
    public static void main(String[] args) {
        loop(10);
        System.out.println(fibonacci(10));
    }

    // パラメータで入った数字の分だけループする有り切ったりのやつ
    public static void loop(int count) {
        for(int idx = 0 ; idx < count ; idx++) {
            System.out.println(idx);
        }
    }

    // メソッドの中でメソッド呼ぶのは可能で、自らを呼ぶのも可能
    // Recursiveという。
    // 終わる条件をちゃんと想定してないと永遠回ってプログラム死んじゃうから注意
    public static int fibonacci(int n) {
        if(n <= 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}