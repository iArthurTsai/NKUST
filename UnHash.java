class UnHash{

    public static void main (String[] args) {
        System.out.println(revHash(6933552791181934L));
        System.out.println(hash("justdoit")); //574318821802
    }

    static final String letters = "cdefghijlmnoqstuvxz";

    public static String revHash(long h) {
        String result = "";
        while (h>7) {
            result = letters.charAt((int)(h%23)) + result;
            h = h/23;
        }
        if (h != 7) {
            System.err.println("Error, hash parity incorrect.");
            System.exit(1);
        }
        return result;
        // write the code here
    }

    public static long hash(String s){
        long h = 7;
        for (int i = 0; i < s.length(); i++){
            h = h * 23 + letters.indexOf(s.charAt(i));
        }
        return h;
    }
}