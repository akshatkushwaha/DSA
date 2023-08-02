public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.divide(4, 0);
    }

    private int divide(int a, int b) {
        int c = -1;
        try {
            c = a / b;
        } catch (Exception e) {
            System.err.println("Exception:");
        } finally {
            System.out.println("Finally");
        }

        return c;
    }
}