public class Utils {
    public static int[] stringToIntArray(String input) {
        input = input.trim();
        if(input.length() < 2) {
            throw new IllegalArgumentException();
        }

        input = input.substring(1, input.length() - 1);
        String[] parts = input.split(",");

        if(parts.length == 0) {
            return new int[0];
        }

        int[] result = new int[parts.length];
        for(int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(parts[i].trim());
        }

        return result;
    }
}
