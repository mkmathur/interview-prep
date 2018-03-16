import java.util.Arrays;

public class ProductsOfOtherNums {
    public static int[] productsOfOtherNums(int[] arr) {
        if(arr.length < 2) {
            throw new IllegalArgumentException();
        }

        int[] result = new int[arr.length];
        Arrays.fill(result, 1);
        multiplyByNumsBeforeIndex(arr, result);
        multiplyByNumsAfterIndex(arr, result);
        return result;
    }

    public static void multiplyByNumsBeforeIndex(int[] arr, int[] result) {
        int product = 1;
        for(int i = 0; i < arr.length - 1; i++) {
            product = product * arr[i];
            result[i + 1] = result[i + 1] * product;
        }
    }

    public static void multiplyByNumsAfterIndex(int[] arr, int[] result) {
        int product = 1;
        for(int i = arr.length - 1; i >= 1; i--) {
            product = product * arr[i];
            result[i - 1] = result[i - 1] * product;
        }
    }

    public static void main(String[] args) {
        int[][] arrs = {
                {1, 7, 3, 4},
                {1, 7, 0, 4}
        };

        for(int[] a: arrs) {
            System.out.println(Arrays.toString(a));
            System.out.println(Arrays.toString(productsOfOtherNums(a)));
            System.out.println();
        }
    }
}
