import java.util.*;

public class Number21_1_100 {
    public static void main(String[] args) {
        HashSet<Integer> nums = new HashSet<Integer>();// Create a HashSet object called nums
        nums.clear();
        System.out.println("HashSet: " + nums);
        for(int i=1;i<=100;i++){
            if(i%21==0){
                nums.add(i);
            }
        }
        TreeSet myTreeSet = new TreeSet();
        myTreeSet.clear();
        myTreeSet.addAll(nums);
        System.out.println("在1~100可以被21整除的數有: " + myTreeSet);// Prints all values
    }
}