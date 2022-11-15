package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class ArrayAndListTwoSidedConversion {

    public static List<Integer> stringArrayToIntegerList(String[] stringArray) {
        List<Integer> integerList = new ArrayList<>();
        for (String s : stringArray) {
            integerList.add(Integer.parseInt(s));
        }
        return integerList;
    }
    public static String[] integerListToStringArray(List<Integer> integerList) {
        String[] stringArray = new String[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            stringArray[i] = String.valueOf(integerList.get(i));
        }
        return stringArray;
    }
}
