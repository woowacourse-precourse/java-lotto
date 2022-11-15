package lotto.validator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Lotto;

public class LottoValidator {
    public static final String BONUS_NOT_BELONG_WINNING = "[ERROR} 보너스 번호는 당첨 번호에 포함되어 있지 않아야 합니다.";
    public static final String BONUS_RANGE = "[ERROR} 보너스 번호는 1~45사이의 숫자여야 합니다.";
    public static final String WINNING_BE_SIX_IN_TOTAL = "[ERROR} 당첨 번호는 6개를 입력해주세요.";
    public static final String INPUT_NUMBER_AND_COMMA = "[ERROR} 쉼표로 구분하여 숫자만 입력해주세요.";
    public static final String LOTTO_RANGE = "[ERROR] 로또 번호는 1~45사이의 숫자여야합니다.";


    public static boolean checkLottoRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(LOTTO_RANGE);
        }
        return true;
    }

    public static void validateBonusNumber(Lotto winningNumber, String bonusNumber) {
        isNumber(bonusNumber);
        checkBonusContain(winningNumber, bonusNumber);
        checkBonusRange(bonusNumber);
    }

    public static void checkBonusContain(Lotto winningNumber, String bonusNumber) {
        if (winningNumber.isContain(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(BONUS_NOT_BELONG_WINNING);
        }
    }

    public static void checkBonusRange(String bonusNumber) {
        if (Integer.parseInt(bonusNumber) < 1 || 45 < Integer.parseInt(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_RANGE);
        }
    }

    public static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_RANGE);
        }
    }

    public static void validateWinningNumber(String input) {
        checkInputForm(input);
        checkNumberCount(input);
    }

    public static void checkInputForm(String input) {
        for (String s : input.split("\\s*,\\s*")) {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(INPUT_NUMBER_AND_COMMA);
            }
        }
    }

    public static void checkNumberCount(String input) {
        List<Integer> collect = Stream.of(input.split("\\s*,\\s*"))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        if (collect.size() != 6) {
            throw new IllegalArgumentException(WINNING_BE_SIX_IN_TOTAL);
        }
    }
}
