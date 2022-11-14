package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoUtil {

    public int StringToInt(String input) {
        if (!isNumeric(input))
            throw new IllegalArgumentException("[ERROR] 입력이 숫자가 아닙니다.");

        return Integer.parseInt(input);
    }

    public List<Integer> StringListToIntList(List<String> input) {
        List<Integer> result = new ArrayList<>();
        for (String current : input) {
            result.add(this.StringToInt(current));
        }
        return result;
    }

    public static boolean isNumeric(String str) {
        return str != null && str.matches("[0-9.]+");
    }
}
