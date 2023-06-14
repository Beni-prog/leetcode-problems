package matrices;

import utils.Utils;

public class FloodFill {

    //it's like in the problem with islands; you have to explore the island that starts at image[sr][sc]
    //and transform every cell
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialPixel = image[sr][sc];

        if (initialPixel == color) {
            return image; // No need to perform flood fill if the initial pixel color is already the new color
        }

        dfs(image, sr, sc, color, initialPixel);

        return image;
    }

    private static void dfs(int[][] image, int sr, int sc, int color, int initialPixel) {

        if (sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0 || image[sr][sc] != initialPixel) {
            return;
        }

        image[sr][sc] = color;

        dfs(image, sr + 1, sc, color, initialPixel);
        dfs(image, sr, sc + 1, color, initialPixel);
        dfs(image, sr - 1, sc, color, initialPixel);
        dfs(image, sr, sc - 1, color, initialPixel);
    }

    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 1, 1, 1}, {1, 1, 2, 1}, {1, 2, 1, 0}, {1, 1, 1, 1}};
        int[][] result = floodFill(image, 1, 2, 2);

        Utils.displayMatrix(result);
    }
}
