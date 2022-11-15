package lotto;

public final class ErrorMessage {
    public static final String INVALID_LOTTO_NUMBER_SIZE_ERROR = "로또 번호는 6개의 숫자여야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE_ERROR = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String LOTTO_NUMBER_DUPLICATE_ERROR = "로또 번호에 같은 수가 중복으로 존재할 수 없습니다.";

    public static final String PURCHASE_AMOUNT_NOT_NUMBER_INPUT_ERROR = "구입 금액은 숫자여야 합니다.";
    public static final String PURCHASE_AMOUNT_NOT_DIVIDED_BY_1000_ERROR = "구입 금액은 1,000으로 나누어 떨어져야 합니다.";

    public static final String WINNING_NUMBER_NOT_NUMBER_INPUT_ERROR =
            "당첨 로또 번호는 ','로 구분되어야 하고, 각 자리는 숫자여야 합니다.";

    public static final String BONUS_NUMBER_NOT_NUMBER_INPUT_ERROR = "보너스 번호는 숫자여야 합니다.";
    public static final String BONUS_NUMBER_EXIST_IN_WINNING_NUMBER_ERROR =
            "보너스 번호는 이미 입력한 당첨 번호에 존재하지 않는 숫자여야 합니다.";

    public static final String INVALID_CORRECT_WINNING_NUMBER_ERROR = "로또에서 맞춘 번호의 개수는 0부터 6 사이의 숫자여야 합니다.";

    private ErrorMessage() {
    }
}
