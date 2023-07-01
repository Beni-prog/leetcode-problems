package recursion;

public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int a, int b) {
        if (a == b) {
            return a;
        }

        if (a < b) {
            return getGreatestCommonDivisor(a, b - a);
        } else {
            return getGreatestCommonDivisor(a- b, b);
        }
    }

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(6, 9));//3
        System.out.println(getGreatestCommonDivisor(50, 25));//3
    }
}
