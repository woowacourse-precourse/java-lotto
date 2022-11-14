package lotto;

public class ErrorMessage {
    // LOTTO
    public static final String LOTTO_NUMBER_SHOULD_BE_SIX = "[ERROR] 로또 번호 개수는 6개여야 합니다.";
    public static final String LOTTO_DUPLICATED = "[ERROR] 로또 번호는 중복되어선 안됩니다.";
    public static final String BONUS_DUPLICATED = "[ERROR] 입력된 보너스 번호는 로또 번호와 중복됩니다.";

    // Client
    public static final String MONEY_NOT_INTEGER = "[ERROR] 금액 입력은 정수여야 합니다.";
    public static final String MONEY_NOT_THOUSANDS_MULTIPLE = "[ERROR] 금액 입력은 1,000의 배수여야 합니다.";
    public static final String NUMBERS_NOT_INTEGERS = "[ERROR] 로또 입력 번호는 숫자여야 합니다.";
    public static final String BONUS_NOT_INTEGER = "[ERROR] 보너스 번호는 정수여야 합니다.";
    public static final String BONUS_NOT_IN_RANGE = "[ERROR] 보너스 번호는 1보다 크고 46보다 작은 숫자여야 합니다.";

}
