import java.util.*;

public class Prime_Number {
    public static void main(String[] args) {

        HashSet<Integer> nums = new HashSet<Integer>();// Create a HashSet object called nums
        nums.clear();
        System.out.println("HashSet: " + nums);
        int i, j;//定義i,j的資料型態。
        for (i = 1; i <= 100; i++) {//定義i的範圍，要找1~100的質數，所以不大於100，i透過迴圈可以加到100。
            for (j = 2; j < i; j++) {//1既不是質數，所以j從2開始。j也可以透過迴圈累加
                if (i % j == 0)//i除以j的餘數=0。
                    break;
            }
            if (j >= i)
                nums.add(j);// Add prime numbers to the set
        }
        TreeSet myTreeSet = new TreeSet();
        myTreeSet.clear();
        myTreeSet.addAll(nums);
        System.out.println("輸出1~100之內的質數有: " + myTreeSet);// Prints all prime numbers
    }
}