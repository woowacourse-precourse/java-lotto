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
}
