package lotto;

public enum ShowErrorMessage {

    ERROR_MESSAGE("[ERROR] "),

    OUT_RANGE_LOTTO_NUMBER_MESSAGE("로또 번호는 1부터 45 사이의 정수여야 합니다."),

    NOT_DIVIDE_MESSAGE("금액은 1,000으로 나누어 떨어져야 합니다."),

    LOTTO_NUMBER_COUNT("당첨 번호의 개수는 6개여야 합니다."),

    DUPLICATE_LOTTO_NUBMER("당첨 번호는 중복될 수 없습니다."),

    CONTAINS_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String errorScript;

    ShowErrorMessage(String errorScript) {
        this.errorScript = errorScript;
    }

    public static void showOutRangeLottoNumber() {
        System.out.println(ERROR_MESSAGE.errorScript + OUT_RANGE_LOTTO_NUMBER_MESSAGE.errorScript);
    }

    public static void showNotDivide() {
        System.out.println(ERROR_MESSAGE.errorScript + NOT_DIVIDE_MESSAGE.errorScript);
    }

    public static void showLottoNumberCount() {
        System.out.println(ERROR_MESSAGE.errorScript + LOTTO_NUMBER_COUNT.errorScript);
    }

    public static void showDuplicateLottoNumber() {
        System.out.println(ERROR_MESSAGE.errorScript + DUPLICATE_LOTTO_NUBMER.errorScript);
    }

    public static void showContainsBonusNumber() {
        System.out.println(ERROR_MESSAGE.errorScript + CONTAINS_BONUS_NUMBER.errorScript);
    }

}
