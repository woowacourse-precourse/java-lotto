package lotto.constants.messages;

public class ExceptionMessage {
    public static final String ERROR = "[ERROR] ";
    public static final String NUMERIC_LENGTH = "하나의 로또는 6개의 숫자로 이루어져야 합니다.";
    public static final String DUPLICATED_NUMBER = "로또의 번호는 중복될 수 없습니다.";
    public static final String NON_NUMERIC_INPUT = "숫자만 입력해야 합니다.";
    public static final String ZERO_INPUT = "0원을 입력할 수 없습니다.";
    public static final String START_WItH_ZERO = "금액은 0으로 시작할 수 없습니다.";
    public static final String WINNING_FORMAT_ERROR = "'1,2,3,4,5,6'과 같은 형식으로 입력해야 합니다.";
    public static final String OUT_OF_BOUNDS = "1~45사이의 숫자를 입력해야 합니다.";

    private ExceptionMessage() {
    }
}
