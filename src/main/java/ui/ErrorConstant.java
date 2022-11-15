package ui;

public final class ErrorConstant {
    public static final String ERROR_HEAD = "[ERROR]";
    public static final String MONEY = " 구입 금액";
    public static final String LOTTO_NUMBER = " 로또 번호";
    public static final String WINNING_LOTTO = " 당첨 번호";
    public static final String INPUT_NOT_NULL = ERROR_HEAD + " " + "입력은 null일 수 없습니다.";
    public static final String INPUT_NOT_BLANK = ERROR_HEAD + " " + "입력은 비어있을 수 없습니다.";
    public static final String MONEY_FIRST_NOT_ZERO = ERROR_HEAD + MONEY + "은 맨 앞자리가 0일 수 없습니다.";
    public static final String MONEY_MORE_THAN_1000 = ERROR_HEAD + MONEY + "은 1000보다 작을 수 없습니다.";
    public static final String MONEY_MUST_NUMBER = ERROR_HEAD + MONEY + "은 0~9의 숫자로 이루어져야 합니다.";

    public static final String LOTTO_NUMBER_FIRST_NOT_ZERO = ERROR_HEAD + LOTTO_NUMBER + "은 맨 앞자리가 0일 수 없습니다.";
    public static final String LOTTO_NUMBER_MUST_NUMBER = ERROR_HEAD + LOTTO_NUMBER + "은 0~9의 숫자로 이루어져야 합니다.";
    public static final String LOTTO_NUMBER_OUT_RANGE = ERROR_HEAD + LOTTO_NUMBER + "는 1~45의 숫자여야 합니다.";

    public static final String WINNING_LOTTO_COMMA = ERROR_HEAD + WINNING_LOTTO + "는 5개의 쉼표로 입력해야 합니다.";
    public static final String WINNING_LOTTO_COMPONENT = ERROR_HEAD + WINNING_LOTTO + "는 숫자여야 합니다.";

    public static final String WINNING_LOTTO_OUT_RANGE = ERROR_HEAD + WINNING_LOTTO + "는 1~45의 숫자여야 합니다.";


    public static final String MONEY_NOT_DIVIDE_1000 = ERROR_HEAD + " " + "돈은 1000단위여야 합니다.";
    public static final String LOTTO_NOT_NUMBER_NULL = ERROR_HEAD + " " + "로또번호는 null일 수 없습니다.";
    public static final String LOTTO_NOT_NULL = ERROR_HEAD + " " + "로또는 null일 수 없습니다.";
    public static final String LOTTO_NOT_SIZE_6 = ERROR_HEAD + " " + "로또는 6개 이외의 로또번호를 가질 수 없습니다.";
    public static final String LOTTO_NOT_DUPLICATE = ERROR_HEAD + " " + "로또는 로또 번호가 중복일 수 없습니다.";

    public static final String LOTTO_NOT_SORTED = ERROR_HEAD + " " + "로또는 숫자가 정렬되어야 합니다.";
}
