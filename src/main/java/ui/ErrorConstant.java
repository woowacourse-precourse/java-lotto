package ui;

public final class ErrorConstant {
    public static final String ERROR_HEAD = "[ERROR]";
    public static final String NOT_NULL_ERROR = ERROR_HEAD + " " + "숫자는 null일 수 없습니다.";
    public static final String NOT_NUMBER_COMPONENT = ERROR_HEAD + " " + "숫자는 0~9의 숫자로 이루어져야 합니다.";
    public static final String NOT_FIRST_NUMBER_ZERO = ERROR_HEAD + " " + "숫자는 맨 앞자리가 0일 수 없습니다.";
    public static final String MONEY_NOT_DIVIDE_1000 = ERROR_HEAD + " " + "돈은 1000단위여야 합니다.";
    public static final String LOTTO_NOT_NUMBER_RANGE = ERROR_HEAD + "[ERROR] 로또번호는 1~45의 숫자여야 합니다.";
    public static final String LOTTO_NOT_NULL = ERROR_HEAD + " " + "로또는 null일 수 없습니다.";
    public static final String LOTTO_NOT_SIZE_6 = ERROR_HEAD + " " + "로또는 6개 이외의 로또번호를 가질 수 없습니다.";
    public static final String LOTTO_NOT_DUPLICATE = ERROR_HEAD + " " + "로또는 로또 번호가 중복일 수 없습니다.";

    public static final String LOTTO_NOT_SORTED = ERROR_HEAD + " " + "로또는 숫자가 정렬되어야 합니다.";
}
