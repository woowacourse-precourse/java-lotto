package lotto.constant;

public class ErrorMessage {
    public static final String PAYMENT_IS_NOT_NUMBER = "[ERROR] 입력한 구입 금액이 정수가 아닙니다.";
    public static final String PAYMENT_IS_NOT_POSITIVE_INTEGER = "[ERROR] 입력한 구입 금액이 양의 정수가 아닙니다.";
    public static final String PAYMENT_IS_NOT_LOTTO_PRICE_UNIT = "[ERROR] 입력한 구입 금액이 "+CommonValue.LOTTO_PRICE+"원 단위가 아닙니다.";
    public static final String NUMBER_COUNT_IS_NOT_SIX = "[ERROR] 번호의 개수가 6개가 아닙니다.";
    public static final String NUMBER_IS_DUPLICATED = "[ERROR] 중복되는 번호가 존재합니다.";
    public static final String INPUT_IS_NOT_WINNING_NUMBERS_FORMAT = "[ERROR] 입력한 값이 당첨 번호의 형식에 맞지 않습니다.";
}