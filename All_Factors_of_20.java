import java.util.*;

public class All_Factors_of_20 {
    public static void main(String[] args) {
        HashSet<Integer> nums = new HashSet<Integer>();// Create a HashSet object called nums
        nums.clear();
        System.out.println("HashSet: " + nums);
        int n = 20;
        String S;
        S = n + "的所有因數: ";
        for (int i = 1; i <= n; i++)
            if (n%i == 0)
                nums.add(i);
        TreeSet myTreeSet = new TreeSet();
        myTreeSet.clear();
        myTreeSet.addAll(nums);
        System.out.println(S + myTreeSet);// Prints all factors
        //"輸出20的因數有: "
    }
}
