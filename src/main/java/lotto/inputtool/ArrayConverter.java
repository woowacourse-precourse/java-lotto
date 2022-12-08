package lotto.inputtool;

import lotto.Exception.Exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayConverter {
    public static List toIntegerList(String[] stringArray) {
        for (int i = 0; i < stringArray.length; i++) {
            String number = stringArray[i];
            Exception.isNum(number);
        }
        int[] intArray = stringArrToIntArr(stringArray);
        return intArrToIntList(intArray);
    }

    public static int[] stringArrToIntArr(String[] stringArray) {
        return Arrays.stream(stringArray).mapToInt(Integer::parseInt).toArray();
    }

    public static List intArrToIntList(int[] intArray) {
        List<Integer> numberList = new ArrayList<>();
        for (int number : intArray) {
            numberList.add(number);
        }
        return numberList;
    }
}
