package lotto.utils;

public class ErrorMessage {
    public static final String LOTTO_MUST_THOUSAND_PRICE = "[ERROR] 구매금액은 1000원 단위여야 합니다.";
    public static final String LOTTO_INPUT_MUST_NUMBER = "[ERROR] 구매금액은 숫자여야만 합니다.";
    public static final String LOTTO_NUMBER_IS_SIX = "[ERROR] 로또의 발행번호는 총 6개여야 합니다. (보너스 제외)";
    public static final String LOTTO_NUMBER_IS_DISTINCT = "[ERROR] 로또의 발행번호들은 중복되지 않아야합니다.";
    public static final String FIRST_NUMBER_IS_NOT_ZERO = "[ERROR] 로또구입 금액이 2자리수가 넘어가면, 맨 앞자리가 0이 될 수 없습니다.";
    public static final String LOTTO_NUMBER_IN_RANGE = "[ERROR] 로또의 번호는 1~45 사이의 값입니다.";
}
