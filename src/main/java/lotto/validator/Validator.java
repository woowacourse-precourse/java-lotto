package lotto.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.ErrorMessage.*;

public class Validator {
    public static final int LOTTO_COUNT = 6;

    private Validator() {
    }

    public static void validateMoney(int money) {
        // TODO money <= 0 고민
        if (money < 0 || money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MONEY);
        }
    }

    public static void validateWinningNumbers(String numbers) {
        Set<String> uniqueNumbers;

        // 쉼표 개수 != 로또 번호 개수
        if (!hasCommaDelimiter(numbers)) {
            throw new IllegalArgumentException(ERROR_COMMA_DELIMITER);
        }

        uniqueNumbers = new HashSet<>(Arrays.asList(numbers.split(",")));

        // Set 을 통한 중복 체크
        if (!isLottoCount(uniqueNumbers)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_SIZE);
        }

        // 1 ~ 45 인지 체크
        if (!isRange(uniqueNumbers)) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }

    private static boolean hasCommaDelimiter(String numbers) {
        return numbers.contains(",");
    }

    private static boolean isLottoCount(Set<String> uniqueNumbers) {
        return uniqueNumbers.size() == LOTTO_COUNT;
    }

    private static boolean isRange(Set<String> uniqueNumbers) {
        int number = 0;

        for (String uniqueNumber : uniqueNumbers) {
            try {
                number = Integer.parseInt(uniqueNumber);
            } catch (NumberFormatException e) {
                return false;
            }

            if (number < 1 || number > 45) {
                return false;
            }
        }

        return true;
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, String bonusNumber) {

        if (!isRange(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }

        if (isDuplicated(winningNumbers, Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_BONUS);
        }
    }

    private static boolean isDuplicated(List<Integer> winningNumbers, int bonusNumber) {
        return winningNumbers.contains(bonusNumber);
    }

    private static boolean isRange(String bonusNumber) {
        int number = 0;

        try {
            number = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            return false;
        }

        if (number < 1 || number > 45) {
            return false;
        }

        return true;
    }
}
