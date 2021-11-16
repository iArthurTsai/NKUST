public class BMI_Calculator {
    public static void main(String[] args) {
        int weight = 73;
        double height = 1.81;
        double BMI;
        BMI = weight/(height*height);
        System.out.println("Your BMI: " + BMI);
    }
}
