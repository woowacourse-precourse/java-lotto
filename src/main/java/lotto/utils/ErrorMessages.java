package lotto.utils;

public class ErrorMessages {
    public static final String LOTTO_NUMBERS_OVER_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String LOTTO_NUMBERS_DUPLICATED = "[ERROR] 로또 번호에 중복된 숫자가 존재합니다.";
    public static final String LOTTO_NUMBERS_OUT_OF_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static final String WINNING_NUMBERS_SEPARATOR = "[ERROR] 당첨 번호는 쉼표(,)를 기준으로 구분해야 합니다.";
    public static final String WINNING_NUMBERS_NOT_INTEGER = "[ERROR] 당첨 번호는 숫자여야 합니다.";

    public static final String BONUS_NUMBER_OUT_OF_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String BONUS_NUMBER_DUPLICATED = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String BONUS_NUMBER_NOT_INTEGER = "[ERROR] 보너스 번호는 숫자여야 합니다.";

    public static final String MONEY_NOT_INTEGER = "[ERROR] 구입 금액은 숫자여야 합니다.";
    public static final String MONEY_OUT_OF_RANGE = "[ERROR] 1000원 이상 구매해야 합니다.";
    public static final String MONEY_NOT_DIVIDE_UNIT = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";

    public static final String NOT_CONDITION_MATCH = "[ERROR] 조건에 맞지 않는 당첨입니다.";
}
