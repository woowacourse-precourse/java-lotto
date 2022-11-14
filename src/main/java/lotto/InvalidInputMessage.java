package lotto;

public class InvalidInputMessage {

    public static String ERR_DEFAULT = "[ERROR] ";

    public static String ERR_MONEY_UNIT = "로또 구매금액은 1000원 단위로 입력해야 합니다.";
    public static String ERR_EMPTY_INPUT = "입력값이 비어있습니다.";
    public static String ERR_NOT_JAVA_INTEGER = "Java int 범위 이내의 숫자만 입력해야 합니다.";
    public static String ERR_NUMBER_RANGE = "로또 번호 범위는 1~45여야 합니다.";
    public static String ERR_WINNING_NUMBER_FORMAT = "당첨 번호는 반점(,)으로 구분되어야 합니다.";
    public static String ERR_NUMBERS_COUNT = "로또 한 줄에 번호는 6개여야 합니다.";
    public static String ERR_DUPLICATED_NUMBER = "당첨 번호와 보너스 번호는 중복되지 않아야 합니다.";
}
