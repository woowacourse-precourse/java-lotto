package lotto.Utils;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<Integer> stringArrayToIntegerList(String[] inputString) {
        List<Integer> inputList = new ArrayList<Integer>();

        for (String s : inputString) {
            inputList.add(Integer.parseInt(s));
        }
        return inputList;
    }
}
