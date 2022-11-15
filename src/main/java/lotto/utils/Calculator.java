package lotto.utils;

import lotto.domains.Place;

import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    private final static int MONEY_CELL = 1000;

    private Calculator() {
    }

    public static int calculateNumberOfLotto(int money) {
        return money / MONEY_CELL;
    }

    public static Place calculatePrize(
            List<Integer> userLottoNumbers,
            List<Integer> winningNumbers,
            int bonusNumber
    ) {
        boolean bonus = userLottoNumbers.contains(bonusNumber);
        int intersection = getIntersection(winningNumbers, userLottoNumbers);

        if (intersection == Place.THIRD.getCorrection()) {
            intersection += 1;
        }

        return Place.getPlace(intersection, bonus);
    }

    private static int getIntersection(List<Integer> userNumbers, List<Integer> winningNumber) {
        return winningNumber.stream()
                .distinct()
                .filter(userNumbers::contains)
                .collect(Collectors.toSet())
                .size();
    }
}
