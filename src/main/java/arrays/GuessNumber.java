package arrays;

public class GuessNumber {

    static int chosenNumber = 6;

    public static int guessNumber(int n) {
        int left = 0;
        int right = n;

        int mid = left + (right - left) / 2;

        while (left <= right) {
            if (0 == guess(mid)) {
                return mid;
            } else if (guess(mid) == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }
        return left - 1;
    }

    private static int guess(int num) {
        return Integer.compare(chosenNumber, num);
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(19));
    }
}
