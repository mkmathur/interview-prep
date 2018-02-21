import java.util.Arrays;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int[] arr = Utils.stringToIntArray(line);
            System.out.println(Arrays.toString(arr));
            System.out.println(getMaxProfit(arr));
            System.out.println();
        }
    }
}
