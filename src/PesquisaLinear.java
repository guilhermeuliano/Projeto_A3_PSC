public class PesquisaLinear {
    public static int linearSearch(long[] array, long target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }

        return -1;
    }
}