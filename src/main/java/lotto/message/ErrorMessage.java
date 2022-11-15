package lotto.message;

public class ErrorMessage {
    public static final String ERROR = "[ERROR] ";
    public static final String NOT_A_NUMBER = ERROR + "입력 값이 숫자가 아닙니다.";
    public static final String WRONG_INPUT = ERROR + "입력 값이 잘못되었습니다.";
    public static final String CANNOT_DIVIDE_BY_BASIC_AMOUNT = ERROR + "로또 기본 금액으로 나누어지는 수가 아닙니다.";
    public static final String CANNOT_SEPARATE = ERROR + "쉼표로 구분된 6개의 문자가 아닙니다.";
    public static final String REPETITION_NUMBERS = ERROR + "중복되는 번호가 있습니다.";
    public static final String REPETITION_NUMBER = ERROR + "기존 값들과 중복되는 번호입니다.";
    public static final String OUT_OF_RANGE = ERROR + "숫자가 범위 내 값이 아닙니다.";
    public static final String MORE_OR_LESS_NUMBERS = ERROR + "로또 번호가 너무 많거나 적습니다";}
