import java.util.*;

public class Remove_Duplicates_Example_1 {
    public static void main(String[] args) {

        HashSet<String> Example_1 = new HashSet<String>();

        // Add numbers to the set
        Example_1.add("1");
        Example_1.add("1");
        Example_1.add("2");

        ArrayList<String> InputExample_1Nums = new ArrayList<String>();

        InputExample_1Nums.add("1");
        InputExample_1Nums.add("1");
        InputExample_1Nums.add("2");

        ArrayList<String> OutputExample_1Nums = new ArrayList<String>();

        OutputExample_1Nums.add("1");
        OutputExample_1Nums.add("2");

        //Remove Duplicates from set
        for (int i = 0; i < InputExample_1Nums.size() - Example_1.size(); i++) {
            OutputExample_1Nums.add("_");
        }

        System.out.println("Example_1");
        System.out.println("Input: " + InputExample_1Nums);
        System.out.println("k = " + Example_1.size());//return k = 2
        System.out.println("Output: " + OutputExample_1Nums);
        System.out.println(Example_1);



        HashSet<String> Example_2 = new HashSet<String>();

        // Add numbers to the set
        Example_2.add("0");
        Example_2.add("0");
        Example_2.add("1");
        Example_2.add("1");
        Example_2.add("1");
        Example_2.add("2");
        Example_2.add("2");
        Example_2.add("3");
        Example_2.add("3");
        Example_2.add("4");

        ArrayList<String> InputExample_2Nums = new ArrayList<String>();

        InputExample_2Nums.add("0");
        InputExample_2Nums.add("0");
        InputExample_2Nums.add("1");
        InputExample_2Nums.add("1");
        InputExample_2Nums.add("1");
        InputExample_2Nums.add("2");
        InputExample_2Nums.add("2");
        InputExample_2Nums.add("3");
        InputExample_2Nums.add("3");
        InputExample_2Nums.add("4");

        ArrayList<String> OutputExample_2Nums = new ArrayList<String>();

        OutputExample_2Nums.add("0");
        OutputExample_2Nums.add("1");
        OutputExample_2Nums.add("2");
        OutputExample_2Nums.add("3");
        OutputExample_2Nums.add("4");

        //Remove Duplicates from set
        for (int i = 0; i < InputExample_2Nums.size() - Example_2.size(); i++) {
            OutputExample_2Nums.add("_");
        }

        System.out.println("Example_2");
        System.out.println("Input: " + InputExample_2Nums);
        System.out.println("k = " + Example_2.size());//return k = 5
        System.out.println("Output: " + OutputExample_2Nums);

    }
}