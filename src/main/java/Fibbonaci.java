public class Fibbonaci {
    public static void main(String[] args) {
        /*System.out.println("Число Фиббоначи:" + fiba(-10));*/
        System.out.println("Число Фиббоначи:" + fib(0));
        System.out.println("Число Фиббоначи:" + fib(1));
        System.out.println("Число Фиббоначи:" + fib(2));
        System.out.println("Число Фиббоначи:" + fib(10));
    }

    public static int fib(int number) {
        int n1 = 1;
        int n2 = 1;
        int n3 = 0;
        if (number == 1 || number == 2) return 1;
        if (number == 0) return 0;
        if (number > 0) {
            for (int i = 3; i <= number; i++) {
                n3 = n1 + n2;
                n1 = n2;
                n2 = n3;
            }
            return n3;
        }
        else
            throw new IllegalArgumentException("Значение должно быть неотрицательным");

    }
}
