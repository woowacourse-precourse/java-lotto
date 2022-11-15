package lotto.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoService.PRIZES;

public class TypeConverter {
    public static List<Integer> convertStringListToIntegerList(List<String> list) {
        return list.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<Integer> convertResultMapToResultList(HashMap<Integer, Integer> resultMap) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int prize : PRIZES) {
            result.add(resultMap.getOrDefault(prize, 0));
        }
        return result;
    }
}
