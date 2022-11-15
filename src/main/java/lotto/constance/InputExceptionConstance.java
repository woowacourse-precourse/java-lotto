package lotto.constance;

public class InputExceptionConstance {
    public static final String ERROR_FORM = "[ERROR] ";
    public static final String NOT_ONLY_NUMBER = "숫자가 아닙니다.";
    public static final String NOT_DIVISIBLE = "1000원으로 나누어 떨어지지 않습니다.";
    public static final String MORE_THAN_NUMBER = "1000원 이상이어야 합니다.";
    public static final String NUMBER_REGEX = "^[0-9]*$";
    public static final String SPACE_REGEX = "^[^\\s]*$";
    public static final String NOT_SPACE = "띄어쓰기를 할 수 없습니다.";
    public static final String NOT_SIX_LENGTH = "숫자의 길이가 6자리가 아닙니다.";
    public static final String BELOW_BONUS_NUMBER = "보너스 숫자는 45이하여야 합니다.";
    public static final String NOT_DUPLICATE = "숫자들은 중복되지 않아야 합니다.";
    public static final String SPLIT_BY_COMMA = "숫자들은 콤마로 구분지어야 합니다.";
    public static final String COMMA = ",";
    public static final int DIVIDING_NUMBER = 1000;

    private InputExceptionConstance() {
    }
}
