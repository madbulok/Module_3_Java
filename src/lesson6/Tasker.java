package lesson6;

import java.util.Arrays;

public class Tasker {

    private static final int FINE_NUM = 4;
    private static final int ANY_FINE_NUM = 1;

//    public static void main(String[] args) {
//        System.out.println(checkArray(new int[]{1,2,3,4}));
//    }

    public int[] sublistAfterLastNumber(int[] array){
        for (int i = array.length-1; i >= 0; i--) {
            if (array[i] == FINE_NUM) return Arrays.copyOfRange(array, ++i, array.length);
        }
        throw new RuntimeException("Value: " + FINE_NUM + " is not exist!");
    }

    public boolean checkArray(int[] arr) {
        long countUniqlEl = Arrays.stream(arr)
                .distinct().count();

        long e = Arrays.stream(arr)
                .distinct()
                .filter(i -> i == ANY_FINE_NUM || i == FINE_NUM)
                .count();

        return e == 2 && e >= countUniqlEl;
    }
}
