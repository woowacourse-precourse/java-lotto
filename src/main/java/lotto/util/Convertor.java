package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.Constant;

public class Convertor {

    public static List<Integer> ExtractList(List<List<Integer>> list, int index) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < Constant.LOTTO_SIZE; i++) {
            result.add(list.get(index).get(i));
        }
        return result;
    }

    public static List<Integer> StringToInteger(List<String> numbers) {
        List<Integer> result = new ArrayList<>();

        for (String number : numbers) {
            result.add(Integer.parseInt(number));
        }
        return result;
    }
}
