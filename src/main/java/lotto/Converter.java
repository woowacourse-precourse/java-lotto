package lotto;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static int stringToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            throw new IllegalArgumentException(Error.NOT_DIGIT_CHARACTER.getDesc());
        }
    }

    public static List<Integer> stringToList(String s) {
        List<Integer> output = new ArrayList<>();
        String[] splitNums = s.split(",");
        for (String splitNum : splitNums) {
            int num = stringToInt(splitNum);
            if(!Validation.lottoNumRange(num))
                throw new IllegalArgumentException(Error.LOTTO_NUM_RANGE.getDesc());
            output.add(num);
        }
        return output;
    }
}
