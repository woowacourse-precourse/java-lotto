package lotto.utils;

import lotto.domains.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberConverter {
    private static final String NUMERIC_ERROR_MSG = "[ERROR] 반드시 쉼표를 기준으로 구분되어야 합니다.";

    public static String convertToString(List<Integer> numbers) {
        return numbers.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    public static List<Integer> convertWinningNumberToList(String bonusNumber) {
        try {
            return Arrays.stream(bonusNumber.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_ERROR_MSG);
        }
    }

    public static List<List<Integer>> convertTo2DimensionalList(List<Lotto> lotteries) {
        return lotteries.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }
}
