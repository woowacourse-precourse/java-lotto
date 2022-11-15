package lotto.constant;

import static lotto.constant.LottoRule.PRICE_OF_ONE_LOTTO;
import static lotto.constant.LottoRule.COUNT_OF_NUMBERS;

public class ErrorMessage {
    // For InputValidator
    public static final String INPUT_INCORRECT_MONEY =
            "[ERROR] " + PRICE_OF_ONE_LOTTO + "의 배수를 입력하세요. 단, 1000000000 미만의 수만 입력해주세요. (ex: "
                    + 2 * PRICE_OF_ONE_LOTTO + ", " + 12345 * PRICE_OF_ONE_LOTTO + ")";
    public static final String INPUT_INCORRECT_WINNING_NUMBERS =
            "[ERROR] " + COUNT_OF_NUMBERS + "개 숫자를 공백 없이 \",\"로 이어 입력해주세요. (ex: 4,13,34,25,7,9)";
    public static final String INPUT_INCORRECT_BONUS_NUMBER = "[ERROR] 문자와 공백 없이, 숫자 1개를 입력해주세요. (ex: 7)";
    public static final String INPUT_TOO_BIG_BONUS_NUMBER = "[ERROR] 너무 큰 수를 입력했습니다.";
    // For Lotto
    public static final String LOTTO_INCORRECT_COUNT = "[ERROR] 로또 번호의 개수가 규칙과 다릅니다.";
    public static final String LOTTO_INCORRECT_RANGE = "[ERROR] 로또 번호의 범위가 규칙과 다릅니다.";
    public static final String LOTTO_DUPLICATED_NUMBER = "[ERROR] 로또 번호에 중복이 있습니다.";
    // For LottoMachine
    public static final String LOTTO_MACHINE_NOT_MULTIPLE_OF_AMOUNT_OF_LOTTO = "[ERROR] " + PRICE_OF_ONE_LOTTO + "의 배수가 아닙니다.";
    // For WinningCalculator
    public static final String WINNING_NUMBERS_HAVE_TOO_BIG = "[ERROR] 숫자가 너무 큽니다.";
    public static final String WINNING_NUMBERS_INCORRECT_COUNT = "[ERROR] 당첨 번호는 " + COUNT_OF_NUMBERS + "개여야 합니다.";
    public static final String WINNING_NUMBERS_INCORRECT_RANGE = "[ERROR] 범위에 맞는 당첨 번호를 입력해주세요.";
    public static final String WINNING_NUMBERS_DUPLICATED = "[ERROR] 당첨 번호가 중복되었습니다.";
    public static final String BONUS_NUMBER_TOO_BIG = "[ERROR] 숫자가 너무 큽니다.";
    public static final String BONUS_NUMBER_INCORRECT_RANGE = "[ERROR] 범위에 맞는 보너스 번호를 입력해주세요.";
    public static final String BONUS_NUMBER_IN_WINNING_NUMBERS_ALREADY = "[ERROR] 당첨 번호에 없는 보너스 번호를 입력해주세요.";
}
