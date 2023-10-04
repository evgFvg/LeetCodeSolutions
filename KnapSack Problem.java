public class KnapSack {

    public static void main(String[] args) {
        int[] weights = {1, 2, 3};
        int[] values = {6, 10, 12};
        int maxWeight = 5;

        int res = getMaxValuePacked(weights, values, maxWeight);


        System.out.println(res);
    }

    private static int getMaxValuePacked(int[] weights, int[] values, int maxWeight) {
        if (weights.length != values.length || maxWeight < 0 || values == null || weights == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        int[][] cache = new int[weights.length + 1][maxWeight + 1];
        for (int i = 1; i <= weights.length; ++i) {
            for (int j = 0; j <= maxWeight; ++j) {
                if (weights[i - 1] > j) {
                    cache[i][j] = cache[i - 1][j];
                } else {
                    cache[i][j] = Math.max(
                            cache[i - 1][j],
                            values[i - 1] + cache[i - 1][j - weights[i - 1]]);
                }

            }
        }

        printMatrix(cache);

        return cache[weights.length][maxWeight];
    }

    private static void printMatrix(int[][] cache) {
        for (int i = 0; i < cache.length; ++i) {
            for (int j = 0; j < cache[i].length; ++j) {
                System.out.print(cache[i][j] + "\t\t");
            }
            System.out.println();
        }
    }

}
