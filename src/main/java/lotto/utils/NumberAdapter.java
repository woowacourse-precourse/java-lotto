package lotto.utils;

import static lotto.constants.LottoConstant.LOTTO_NUMBER_SEPARATOR;
import static lotto.validator.LottoNumberValidator.hasValidLottoNumberType;
import static lotto.validator.NumberValidator.hasValidType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberAdapter {
    public static List<Integer> fitWinningNumber(String beforeWinningNumber) {
        hasValidLottoNumberType(beforeWinningNumber);
        String[] tempWinningNumber = beforeWinningNumber.split(LOTTO_NUMBER_SEPARATOR);
        int[] afterWinningNumber = Arrays.stream(tempWinningNumber).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(afterWinningNumber).boxed().collect(Collectors.toList());
    }

    public static int fitBonusNumber(String beforeBonusNumber) {
        hasValidType(beforeBonusNumber);
        return Integer.parseInt(beforeBonusNumber);
    }

    public static List<Integer> fitWinningNumberWithBonusNumber(List<Integer> winningNumber, int bonusNumber) {
        winningNumber.add(bonusNumber);
        return winningNumber;
    }

    public static int fitPaidMoney(String beforePaidMoney) {
        hasValidType(beforePaidMoney);
        return Integer.parseInt(beforePaidMoney);
    }
}
