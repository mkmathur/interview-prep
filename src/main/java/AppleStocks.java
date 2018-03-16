import java.util.Arrays;

public class AppleStocks {
    public static int getMaxProfit(int[] prices) {
        if(prices.length < 2) {
            throw new IllegalArgumentException();
        }

        int maxProfit = prices[1] - prices[0];
        int minPrice = prices[0];

        for(int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            int potentialProfit = currentPrice - minPrice;
            maxProfit = Math.max(maxProfit, potentialProfit);
            minPrice = Math.min(minPrice, currentPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[][] arrs = {
                {12, 1, 5, 9, 11, 3},
                {12, 1},
                {12, 10, 8, 6}
        };

        for(int[] a: arrs) {
            System.out.println(Arrays.toString(a));
            System.out.println(getMaxProfit(a));
            System.out.println();
        }
    }
}

