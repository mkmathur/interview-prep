import java.util.Arrays;

public class HighestProductOf3 {
    public static int highestProductOf3(int[] arr) {
        // at each step, to figure out if we can get a higher product of 3, we need to know
        // the highest and lowest products of 2, and the highest and lowest elements.
        int highestProdOf3 = arr[0] * arr[1] * arr[2];

        int highestProdOf2 = arr[0] * arr[1];
        int lowestProdOf2 = arr[0] * arr[1];

        int highest = Math.max(arr[0], arr[1]);
        int lowest = Math.min(arr[0], arr[1]);

        for(int i = 2; i < arr.length; i++) {
            int n = arr[i];

            // can we get a higher product of 3?
            int potentialProductOf3 = Math.max(n * highestProdOf2, n * lowestProdOf2);
            highestProdOf3 = Math.max(highestProdOf3, potentialProductOf3);

            // can we get a higher product of 2?
            int potentialProductOf2 = Math.max(n * highest, n * lowest);
            highestProdOf2 = Math.max(highestProdOf2, potentialProductOf2);

            // can we get a lower product of 2?
            potentialProductOf2 = Math.min(n * highest, n * lowest);
            lowestProdOf2 = Math.min(lowestProdOf2, potentialProductOf2);

            // update highest and lowest
            highest = Math.max(highest, n);
            lowest = Math.min(lowest, n);
        }

        return highestProdOf3;
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {1, -2, 3, -4, 5},
                {-1, 5, 3 ,2, 4, -2, -7, 0, 1},
                {-7, -5, -2, -1, 0},
                {1, 2, -3}
        };

        for(int[] arr: arrays) {
            int res = highestProductOf3(arr);
            System.out.println(Arrays.toString(arr));
            System.out.println(res);
            System.out.println();
        }
    }
}
