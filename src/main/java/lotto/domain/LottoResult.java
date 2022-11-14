package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {
    private static int FIRST_PLACE = 5;
    private static int SECOND_PLACE = 4;
    private static int THIRD_PLACE = 3;
    private static int FOURTH_PLACE = 2;
    private static int FIFTH_PLACE = 1;
    private static int SIXTH_PLACE = 0;

    public static List<Integer> getResult(List<Lotto> lottos, List<Integer> winningNumber, Integer bonusNumber) {
        int[] result = {0, 0, 0, 0, 0, 0};
        for (List<Integer> numbers : lottos.stream().map(lotto -> lotto.getNumbers()).collect(Collectors.toList())) {
            int index = compareNumber(numbers, winningNumber, bonusNumber);
            result[index]++;
        }
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    public static int compareNumber(List<Integer> lottoNumbers, List<Integer> winningNumbers, Integer bonusNumber) {
        int matchingCount = 0;

        for (Integer winningNumber : winningNumbers) {
            if (lottoNumbers.contains(winningNumber)) {
                matchingCount++;
            }
        }

        if (matchingCount == 6) {
            return FIRST_PLACE;
        }

        if (winningNumbers.contains(bonusNumber)) {
            matchingCount++;
        }

        switch (matchingCount) {
            case 6:
                return SECOND_PLACE;
            case 5:
                return THIRD_PLACE;
            case 4:
                return FOURTH_PLACE;
            case 3:
                return FIFTH_PLACE;
            default:
                return SIXTH_PLACE;
        }

    }
}
