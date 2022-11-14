package util;

import lotto.Lotto;
import lotto.Money;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public static final int ZERO = 0;
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;

    public static void validateDigits(String readLine) {
        if (!readLine.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다. readLine: " + readLine);
        }
    }

    public static void validateUnit(int money) {
        if (money % Money.UNIT != ZERO) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 나누어 떨어지지 않습니다. money: " + money);
        }
    }

    public static void validateWinningNumbersRange(List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            if (winningNumber < MINIMUM_LOTTO_NUMBER || MAXIMUM_LOTTO_NUMBER < winningNumber) {
                throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1~45까지입니다. winningNumbers: " + winningNumbers);
            }
        }
    }

    public static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < MINIMUM_LOTTO_NUMBER || MAXIMUM_LOTTO_NUMBER < bonusNumber) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 숫자 범위는 1~45까지입니다. bonusNumber: " + bonusNumber);
        }
    }

    public static void validateSplitSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != Lotto.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 입력된 숫자가 로또 당첨 번호 수에 맞지 않습니다. winningNumbers: " + winningNumbers);
        }
    }

    public static void validateDuplicateWinningNumbers(List<Integer> winningNumbers) {
        Set<Integer> set = new HashSet<>(winningNumbers);

        if (set.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 숫자는 중복되어선 안됩니다. winningNumbers: " + winningNumbers);
        }
    }

    public static void validateMinimumMoney(int money) {
        if (money < Money.UNIT) {
            throw new IllegalArgumentException("[ERROR] 천원 이하는 복권을 살 수 없습니다. money: " + money);
        }
    }
}
