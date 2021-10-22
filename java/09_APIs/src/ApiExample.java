import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ApiExample {
    public static void main(String[] args) {
        ScannerExample scannerExample = new ScannerExample();
        scannerExample.execute();

        ArrayExample arrayExample = new ArrayExample();
        arrayExample.execute();
    }
}

class ScannerExample {
    public void execute() {
        // このScannerはシステムのインプットから読み込むよ-とパラメーターに明示
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input string");
        String inputString = sc.nextLine();
        System.out.println("Please input integer");
        int inputInteger = sc.nextInt();
        System.out.println("String" + inputString);
        // ここで数字以外を入れたらどうなるかな？
        System.out.println("Integer" + inputInteger);

        // この下のコードでは、数字を先に入力させたいだけなのに
        // 文字列入力しようとしてもできない。
        // これはなぜかな？
        // Hint : input stream, EOL, \n
        System.out.println("Please input integer : ");
        inputInteger = sc.nextInt();
        System.out.println("Please input string : ");
        inputString = sc.nextLine();
        System.out.println("String : " + inputString);
        System.out.println("Integer : " + inputInteger);

        // nextLine以外、nextというのもある。何が違うかな？
        // 空白入れたりして試してみましょう
        System.out.println("Please input string");
        inputString = sc.next();
        System.out.println("String : " + inputString);
        // このあとにsc.nextInt()とか入れたらどうなるかな？やってみましょう
    }
}

class ArrayExample {
    int[] intArray = new int[5];
    // なんでintではなくIntegerにすべきかな？
    // ＜＞はまたなにかな？後で出るGenericってやつ。
    // 2つは関係あるかも
    ArrayList<Integer> intArrayList = new ArrayList<>();

    public void execute() {
        Scanner sc = new Scanner(System.in);

        // ここで5以上したらどうなるかな？
        System.out.println("Loop time");
        int loop = sc.nextInt();

        for(int idx = 0 ; idx < loop ; idx++) {
            intArray[idx] = idx+1;
            intArrayList.add(idx, idx+1);
        }

        // Loopを5未満にしたらどうなるかな？
        System.out.println(Arrays.toString(intArray));
        System.out.println(intArray.length);

        System.out.println(intArrayList.toString());
        System.out.println(intArrayList.size());
    }
}