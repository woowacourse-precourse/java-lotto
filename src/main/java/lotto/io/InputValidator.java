package lotto.io;

import java.util.List;

public class InputValidator {
    private static final String ERROR_ONLY_NUMBER = "[ERROR] 숫자만 입력해 주세요.";
    private static final String ERROR_SIX_NUMBER = "[ERROR] 당첨 번호는 6개 입력해 주세요.";
    private static final String ERROR_IN_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_BONUS_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    public static void validateToParseInt(String str) throws Exception {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBER);
        }
    }

    public static void validateWinningNumbers(String numbers) throws Exception{
        for (String number : numbers.trim().split(",")) {
            validateToParseInt(number);
            validateInRange(number);
        }
        if (numbers.split(",").length != 6)
            throw new IllegalArgumentException(ERROR_SIX_NUMBER);
    }

    public static void validateBonusNumber(List<Integer> winningNumbers,
                                           String number) throws Exception {
        validateToParseInt(number);
        validateInRange(number);
        validateIsBonusDuplicated(winningNumbers, number);
    }

    private static void validateInRange(String number) throws  Exception {
        int num = Integer.parseInt(number);
        if (num < 1 || num > 45)
            throw new IllegalArgumentException(ERROR_IN_RANGE);
    }

    private static void validateIsBonusDuplicated(List<Integer> winningNumbers,
                                                  String number) throws Exception {
        if (winningNumbers.contains(Integer.parseInt(number)))
            throw new IllegalArgumentException(ERROR_BONUS_DUPLICATE);
    }
}
