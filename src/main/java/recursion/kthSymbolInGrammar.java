package recursion;

public class kthSymbolInGrammar {

    public static int kthGrammar(int n, int k) {
        // Base case
        if (n == 1) {
            return 0;
        }

        // Calculate the midpoint of the previous row
        int midpoint = (int) Math.pow(2, n - 1) / 2;

        // Recursive case
        if (k <= midpoint) {
            return kthGrammar(n - 1, k);
        } else {
            int symbol = kthGrammar(n - 1, k - midpoint);
            return symbol == 0 ? 1 : 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(kthGrammar(4, 3));//1
    }
}
