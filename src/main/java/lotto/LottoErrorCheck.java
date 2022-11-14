package lotto;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.Pattern;

public class LottoErrorCheck {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String INPUT_FORMAT_ERROR = ERROR_MESSAGE + " 숫자를 입력해야합니다.";
    private static final String MONEY_NOT_DIVIDED_ERROR = ERROR_MESSAGE + " 구입금액은 1000으로 나누어 떨어져야합니다.";
    private static final String WINNING_NUMBER_SIZE_ERROR = ERROR_MESSAGE + " 당첨 번호는 6개여야 합니다.";
    private static final String WINNING_NUMBER_DUPLICATION_ERROR = ERROR_MESSAGE + " 당첨 번호 6개는 서로 다른 숫자이어야 합니다.";
    private static final String LOTTO_NUMBER_SIZE_ERROR = ERROR_MESSAGE + " 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String BONUS_NUMBER_INCLUDED_WINNING_NUMBER = ERROR_MESSAGE + " 보너스 번호는 당첨 번호와 달라야 합니다.";
    private static final String NUMBER_PATTERN = "^[0-9]{1,}$";
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_MIN = 1;

    public static void moneyErrorCheck(String money) {

        if (!Pattern.matches(NUMBER_PATTERN, money))
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR);

        if ((Integer.parseInt(money) % LOTTO_PRICE) != 0)
            throw new IllegalArgumentException(MONEY_NOT_DIVIDED_ERROR);
    }

    public static void winningNumberErrorCheck(List<String> numbers) {
        if (numbers.size() != LOTTO_SIZE)
            throw new IllegalArgumentException(WINNING_NUMBER_SIZE_ERROR);

        Set<String> duplicationCheck = new HashSet<>(numbers);
        if (duplicationCheck.size() != LOTTO_SIZE)
            throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATION_ERROR);

        for (int i = 0; i < LOTTO_SIZE; i++)
            if (!Pattern.matches(NUMBER_PATTERN, numbers.get(i)))
                throw new IllegalArgumentException(INPUT_FORMAT_ERROR);

        int num;
        for (int i = 0; i < LOTTO_SIZE; i++) {
            num = Integer.parseInt(numbers.get(i));
            if (num > LOTTO_NUMBER_MAX || num < LOTTO_NUMBER_MIN)
                throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_ERROR);
        }

    }

    public static void bonusNumberErrorCheck(String number) {
        if (!Pattern.matches(NUMBER_PATTERN, number))
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR);

        int num = Integer.parseInt(number);
        if (num > LOTTO_NUMBER_MAX || num < LOTTO_NUMBER_MIN)
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_ERROR);
    }

    public static void checkBonusNumberIncludedWinningNumber(List<Integer> winningNumber, Integer bonusNumber) {
        if (winningNumber.contains(bonusNumber))
            throw new IllegalArgumentException(BONUS_NUMBER_INCLUDED_WINNING_NUMBER);
    }
}
