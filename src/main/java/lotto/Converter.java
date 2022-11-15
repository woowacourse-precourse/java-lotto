package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Converter {

    public static int stringToInt(String s) {
        int output = 0;
        try {
            output =  Integer.parseInt(s);
        } catch (Exception e) {
            Output.showError(Error.NOT_DIGIT_CHARACTER);
        }
        return output;
    }

    public static List<Integer> stringToList(String s) {
        List<Integer> output = new ArrayList<>();
        String[] splitNums = s.split(",", -1);
        for (String splitNum : splitNums) {
            int num = stringToInt(splitNum);
            if(!Validation.lottoNumRange(num))
                Output.showError(Error.LOTTO_NUM_RANGE);
            output.add(num);
        }
        return output;
    }

    public static Set<Integer> listToSet(List<Integer> arr) {
        return new HashSet<>(arr);
    }
}
