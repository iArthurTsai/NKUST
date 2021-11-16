public class Prime_Number {
    public static void main(String[] args) {
        int i, j;
        for (i = 1; i <= 100; i++) {
            for (j = 2; j < i; j++) {//1既不是質數，所以從2開始
                if (i % j == 0)
                    break;
            }
            if (j >= i)
                System.out.println("輸出1~100之內的質數有 " +j);
        }
    }
}
