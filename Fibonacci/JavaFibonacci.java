public class JavaFibonacci {
    public static void main(String[] args) {
        int first = 0;
        int second = 1;
        int temp;

        int n = 2; // Change this for nth value

        if(n == 1) {
            System.out.println(0);
            return;
        } else if (n == 2) {
            System.out.println("0\n1");
            return;
        }

        System.out.println("0\n1");
        for (int i = 0; i < n - 2; i++) {
            temp = first;
            first = second;
            second = first + temp;
            System.out.println(second);
        }
    }
}
