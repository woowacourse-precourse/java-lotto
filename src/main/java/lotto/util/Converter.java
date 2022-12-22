package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static List<Integer> stringToIntList(String before, String delimeter) {
        List<Integer> after = new ArrayList<>();

        for (String element : stringToStringArray(before, delimeter)) {
            after.add(Integer.parseInt(element));
        }
        return after;
    }

    public static String[] stringToStringArray(String before, String delimeter) {
        return before.split(delimeter);
    }

    public static int stringToInt(String before) {
        return Integer.parseInt(before);
    }
}
