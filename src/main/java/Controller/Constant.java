package Controller;

public class Constant {
    static final int LOTTO_PRICE = 1000;
    static final int LOTTO_LENGTH = 6;
    static final int LOTTO_NUMBER_RANGE_START = 1;
    static final int LOTTO_NUMBER_RANGE_END = 45;
    static final String REGEX_NUMERIC = "^[0-9]*$";
    static final String DELIMITER = ",";
    static final String ERROR_MESSAGE = "[ERROR]";

    static final String ERROR_MESSAGE_NOT_NUMERIC = ERROR_MESSAGE + " 숫자로 이루어진 입력이 아닙니다.";
    static final String ERROR_MESSAGE_MONEY_IS_INSUFFICIENT = ERROR_MESSAGE + " 입력이 로또 가격(" + LOTTO_PRICE + "원)보디 낮은 숫자입니다.";
    static final String ERROR_MESSAGE_NOT_MULTIPLE_LOTTO_PRICE = ERROR_MESSAGE + " 입력이 로또 가격(" + LOTTO_PRICE + "원)의 배수인 숫자가 아닙니다.";
    static final String ERROR_MESSAGE_DELIMITER_NUMBER_IS_INCORRECT = ERROR_MESSAGE + " 구분자(" + DELIMITER + ")의 개수가 입력 조건에 맞지 않습니다.";
    static final String ERROR_MESSAGE_BETWEEN_NUMBER_NOT_DELIMITER = ERROR_MESSAGE + " 당첨 번호 입력에서 구분자(" + DELIMITER + ")의 위치가 입력 조건에 맞지 않습니다. 콤마(,)는 숫자 사이에 존재해야 합니다.";
    static final String ERROR_MESSAGE_BETWEEN_DELIMITER_NOT_NUMBER = ERROR_MESSAGE + " 당첨 번호 입력에서 구분자(" + DELIMITER + ")사이에 데이터가 숫자로 이루어진 데이터가 아닙니다.";
    static final String ERROR_MESSAGE_WINNING_NUMBER_IS_DUPLICATED = ERROR_MESSAGE + " 당첨 번호 중에서 중복된 숫자가 존재합니다.";
    static final String ERROR_MESSAGE_NUM_IS_OUT_OF_RANGE = ERROR_MESSAGE + " 입력이 " + LOTTO_NUMBER_RANGE_START + "~" + LOTTO_NUMBER_RANGE_END + " 범위 내의 숫자가 아닙니다.";
    static final String ERROR_MESSAGE_BONUS_IS_DUPLICATED = ERROR_MESSAGE + " 입력한 보너스 번호는 당첨 번호와 중복된 값입니다.";
}
