package lotto.constant;

public class ErrorMessage {
    //View 에러메세지
    public static final String TYPE_IS_NOT_RIGHT = "[ERROR] 숫자를 입력해야 합니다.";

    //Domain 에러메세지
    public static final String NUMBER_DOES_NOT_DIVIDED_BY_THOUSAND = "[ERROR] 1000으로 나누어 떨어지지 않는 값은 입력해야 합니다.";
    public static final String INPUT_HAS_DUPLICATED_NUMBER = "[ERROR] 중복되지 않는 숫자를 입력해야 합니다.";
    public static final String NUMBER_EXCEEDS_NORMAL_RANGE = "[ERROR] 1에서 45 사이의 수를 입력해야 합니다.";
    public static final String NUMBER_OF_NUMBERS_DOES_NOT_MATCH = "[ERROR] 당첨 번호는 6개를 입력해야 합니다.";
    public static final String INPUT_HAS_NEGATIVE_NUMBER_OR_ZERO = "[ERROR] 양수를 입력해야 합니다.";
}
