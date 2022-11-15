package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class Convertor {

    // 이중 리스트에서 리스트 한 개씩 추출하는 기능
    public static List<Integer> ExtractList(List<List<Integer>> list, int index) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < Lotto.getSize(); i++) {
            result.add(list.get(index).get(i));
        }
        return result;
    }

    // String 타입 List를 Integer 타입 List로 변환하는 기능
    public static List<Integer> StringToInteger(List<String> numbers) {
        List<Integer> result = new ArrayList<>();

        for (String number : numbers) {
            result.add(Integer.parseInt(number));
        }
        return result;
    }
}
