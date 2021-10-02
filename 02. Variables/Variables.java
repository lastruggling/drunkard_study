public class Variables {
    public static void main(String[] args) {
        // Boolean. True Falseそれ
        boolean boolPrimitive = true;
        //　Character.一文字
        char charPrimitive = 'a';
        // 整数系変数
        byte bytePrimitive = 'b';
        short shortPrimitive = 30000;
        int intPrimitive = 2000000000;
        long longPrimitive = 9_000_000_000_000_000_000L;
        // 少数系変数
        float floatPrimitive = 0.123456789F;
        double doublePrimitive = 0.123456789123456789;

        System.out.println(boolPrimitive);
        System.out.println(charPrimitive);
        System.out.println(bytePrimitive);
        System.out.println(shortPrimitive);
        System.out.println(intPrimitive);
        System.out.println(longPrimitive);
        System.out.println(floatPrimitive);
        System.out.println(doublePrimitive);

        // VariableをObject化してるのもある。Wrapperという
        Boolean boolObject = false;
        Character charObject = 'a';
        // 整数系変数
        Byte byteObject = 'b';
        Short shortObject = 30000;
        Integer intObject = 2_000_000_000;
        Long longObject = 9_000_000_000_000_000_000L;
        // 少数系変数
        Float floatObject = 0.123456789F;
        Double doubleObject = 0.123456789123456789;

        // Wrapperがなぜあるかなどは検索してみましょう
        // なんで同じ整数や少数でも違うサイズを使うため
        // Booleanは１ビットだからか、これで出てこない
        System.out.println(Character.BYTES);
        System.out.println(Byte.BYTES);
        System.out.println(Short.BYTES);
        System.out.println(Integer.BYTES);
        System.out.println(Long.BYTES);
        System.out.println(Float.BYTES);
        System.out.println(Double.BYTES);

        // 整数と整数の演算の結果は整数になってしまう
        // なので、少数にしたい場合は少数系に型変換をする必要がある
        // Type Castingという
        int three = 3;
        int five = 5;
        System.out.println(three/five);
        System.out.println((double)three/five);
    }
}
