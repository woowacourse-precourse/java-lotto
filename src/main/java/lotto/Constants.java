package lotto;

public final class Constants {

    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;
    public static final int LOTTO_PRICE = 1_000;
    public static final int MONEY_TERMS = 1_000;

    public static final String CONSOLE_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String CONSOLE_LOTTO_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String CONSOLE_MONEY = "구입금액을 입력해 주세요.";
    public static final String CONSOLE_BUY_RESULT = "개를 구매했습니다.";

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String LOTTO_NUMBERS_LEN_EXCEPTION = "로또 번호는 6자리 숫자여야 합니다.";
    public static final String LOTTO_NUMBERS_RANGE_EXCEPTION = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String LOTTO_NUMBERS_DUPLICATE_EXCEPTION = "로또 번호는 중복되지 않아야 합니다.";
    public static final String LOTTO_MONEY_EXCEPTION = "구입 금액은 1,000원 단위로 입력하여야 합니다.";
}
