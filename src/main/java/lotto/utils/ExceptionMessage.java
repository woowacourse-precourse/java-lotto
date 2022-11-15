package lotto.utils;

public class ExceptionMessage {
    public static final String USER_INPUT_NOT_NUMBER_EXCEPTION = "[ERROR] 숫자만 입력 가능합니다.";
    public static final String USER_INPUT_NULL_EXCEPTION = "[ERROR] 금액을 입력 해주세요.";
    public static final String AMOUNT_NOT_DIVISIBLE_EXCEPTION = "[ERROR] 1,000원 단위의 금액만 입력 가능합니다.";
    public static final String LOTTO_NUMBERS_NOT_SIX_EXCEPTION = "[ERROR] 당첨 숫자 6개를 입력해 주세요.";
    public static final String LOTTO_NUMBERS_NOT_Distinct_EXCEPTION = "[ERROR] 서로 다른 숫자 6개를 입력해 주세요.";
    public static final String LOTTO_NUMBERS_RANGE_EXCEPTION = "[ERROR] 1~45 사이의 숫자만 입력 가능합니다.";
    public static final String BONUS_NUMBER_OVERLAP_EXCEPTION = "[ERROR] 보너스 숫자가 당첨 숫자와 겹칩니다.";
    public static final String RESULT_NOT_CORRECT_EXCEPTION = "[ERROR] 조건에 맞지 않는 당첨입니다.";
}
