package lotto.validator;

import lotto.constant.ErrorMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static lotto.constant.ErrorMessage.*;

public class Validator {
    public static final int LOTTO_COUNT = 6;

    public void validateMoney(int money) {
        if (money < 0 || money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MONEY);
        }
    }

    public void validateWinningNumbers(String numbers) {
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

    private boolean hasCommaDelimiter(String numbers) {
        return numbers.contains(",");
    }

    private boolean isLottoCount(Set<String> uniqueNumbers) {
        return uniqueNumbers.size() == LOTTO_COUNT;
    }

    private boolean isRange(Set<String> uniqueNumbers) {
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
}
