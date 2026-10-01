public class Main {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--demo")) {
            System.out.println("SUMMARY: 0/0 PASS");
        } else {
            System.out.println("Usage: java -cp out Main --demo");
        }
    }
}