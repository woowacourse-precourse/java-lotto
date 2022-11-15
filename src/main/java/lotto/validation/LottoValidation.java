package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.ErrorConstant.*;
import static lotto.constant.LottoConstant.*;

public class LottoValidation {
    public static void canBuyLotto(int userMoney) {
        if (userMoney < LOTTO_BASE_PRICE || (userMoney % LOTTO_BASE_PRICE) != 0) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_MONEY);
        }
    }

    public static void isValidLotto(List<Integer> lotto) {
        if (!checkCountOfNumbers(lotto)) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_COUNT);
        }
        if (!checkDuplicateNumber(lotto)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
        }
        if (!isValidRangeOfLottoNumbers(lotto)) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
        }

    }

    private static boolean checkCountOfNumbers(List<Integer> lotto) {
        if (lotto.size() != LOTTO_COUNT_NUMBER) {
            return false;
        }
        return true;
    }
    private static boolean checkDuplicateNumber(List<Integer> lotto) {
        Set<Integer> distinctLotto = new HashSet<>(lotto);
        if (distinctLotto.size() != lotto.size()) {
            return false;
        }
        return true;
    }
    private static boolean isValidRangeOfLottoNumbers(List<Integer> lotto) {
        for (int number : lotto) {
            if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
                return false;
            }
        }
        return true;
    }

    public static void isValidRangeOfBonusNumber(String inputBonus) {
        int bonusNumber = Integer.parseInt(inputBonus);

        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
        }
    }

    public static void isContainBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if  (winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
        }
    }
}
