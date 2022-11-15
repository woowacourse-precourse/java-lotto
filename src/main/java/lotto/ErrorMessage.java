package lotto;

public class ErrorMessage {
    static final String ERROR = "[ERROR] ";
    static final String NOT_A_NUMBER = ERROR + "입력 값이 숫자가 아닙니다.";
    static final String WRONG_INPUT = ERROR + "입력 값이 잘못되었습니다.";
    static final String CANNOT_DIVIDE_BY_BASIC_AMOUNT = ERROR + "로또 기본 금액으로 나누어지는 수가 아닙니다.";
    static final String CANNOT_SEPARATE = ERROR + "쉼표로 구분된 6개의 문자가 아닙니다.";
    static final String REPETITION_WINNING = ERROR + "중복되는 당첨 번호가 있습니다.";
    static final String REPETITION_BONUS = ERROR + "보너스 번호가 당첨 번호와 중복됩니다.";
    static final String OUT_OF_RANGE = ERROR + "숫자가 범위 내 값이 아닙니다.";
    static final String TOO_MUCH_NUMBERS = ERROR + "로또 번호가 너무 많습니다.";
    static final String REPETITION_LOTTO_NUMBERS = ERROR + "로또 번호가 중복됩니다.";
}
