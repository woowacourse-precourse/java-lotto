package lotto.util;

public final class ErrorMessage {

    private static final String ERROR = "[ERROR] ";

    public static final String IS_NOT_NUMBER = ERROR + "구입 금액은 숫자여야 합니다.";
    public static final String IS_NOT_POSITIVE_NUMBER = ERROR + "구입 금액은 양수여야 합니다.";
    public static final String IS_NOT_NUMBER_AND_COMMA = ERROR + "당첨 번호는 공백 없이 숫자와 콤마로만 이루어져야 합니다.";
    public static final String IS_NOT_NUMBER_TO_BONUS = ERROR + "보너스 번호는 숫자여야 합니다.";

    public static final String IS_NOT_DIVISIBLE_LOTTO =
            ERROR + "구입 금액은 " + LottoConstants.LOTTO_PRICE_UNIT + "원으로 나누어 떨어져야 합니다.";
    public static final String IS_NOT_LOTTO_SIZE =
            ERROR + "로또 번호의 개수는 " + LottoConstants.LOTTO_TICKET_SIZE + "개여야 합니다.";
    public static final String IS_NOT_RANGE_LOTTO_NUMBER =
            ERROR + "로또 번호의 범위는 " + LottoConstants.LOTTO_MIN_NUMBER + " ~ " + LottoConstants.LOTTO_MAX_NUMBER
                    + " 사이여야 합니다.";
    public static final String IS_NOT_UNIQUE_LOTTO_NUMBER = ERROR + "로또 번호는 중복되지 않는 유일한 숫자여야 합니다.";

    private ErrorMessage() {

    }

}
