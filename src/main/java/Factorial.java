public class Factorial {
    public static void main(String[] args) {
        System.out.println("Факториал:" + factorial(10));
    }

    public static int factorial(int value) {
        if (value<0) throw new IllegalArgumentException("Значение должно быть неотрицательным");
        int x = 1;
        if (value==0) return x;
        for (int i = 1; i <= value; i++) {
            x = x * i;
        }
        return x;
    }
}
