package lotto;

public class ShowErrorMessage {

    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String OUT_RANGE_LOTTO_NUMBER_MESSAGE = "로또 번호는 1부터 45 사이의 정수여야 합니다.";
    private static final String NOT_DIVIDE_MESSAGE = "금액은 1,000으로 나누어 떨어져야 합니다.";
    private static final String LOTTO_NUMBER_COUNT = "당첨 번호의 개수는 6개여야 합니다.";
    private static final String DUPLICATE_LOTTO_NUBMER = "당첨 번호는 중복될 수 없습니다.";
    private static final String CONTAINS_BONUS_NUMBER = "보너스 번호는 당첨번호와 중복될 수 없습니다.";

    public static void showOutRangeLottoNumber() {
        System.out.println(ERROR_MESSAGE + OUT_RANGE_LOTTO_NUMBER_MESSAGE);
    }

    public static void showNotDivide() {
        System.out.println(ERROR_MESSAGE + NOT_DIVIDE_MESSAGE);
    }

    public static void showLottoNumberCount() {
        System.out.println(ERROR_MESSAGE + LOTTO_NUMBER_COUNT);
    }

    public static void showDuplicateLottoNumber() {
        System.out.println(ERROR_MESSAGE + DUPLICATE_LOTTO_NUBMER);
    }

    public static void showContainsBonusNumber() {
        System.out.println(ERROR_MESSAGE + CONTAINS_BONUS_NUMBER);
    }

}
