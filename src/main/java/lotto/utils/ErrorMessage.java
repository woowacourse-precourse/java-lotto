package lotto.utils;

public interface ErrorMessage {
    String PREFIX = "[ERROR] ";
    String DUPLICATED_NUMBERS = "서로 중복된 숫자를 입력할 수 없습니다.";
    String NUMBERS_OUT_OF_RANGE = "1 부터 45 사이의 숫자를 입력해주세요.";
    String MONEY_LEFT_OVER = "천원 단위의 금액만 입력해주세요.";
    String CONTAINS_NON_NUMERIC_VALUES = "문자열을 포함시킬 수 없습니다.";
    String IS_EMPTY = "공백을 입력할 수 없습니다.";
    String INVALID_SIZE = "6개의 숫자를 입력해주세요.";
}
