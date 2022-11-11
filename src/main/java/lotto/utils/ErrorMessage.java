package lotto.utils;

public interface ErrorMessage {
    String DUPLICATED_NUMBERS = "[ERROR] 서로 중복된 숫자를 입력할 수 없습니다.";
    String NUMBERS_OUT_OF_RANGE = "[ERROR] 1 부터 45 사이의 숫자를 입력해주세요.";
    String MONEY_LEFT_OVER = "[ERROR] 천원 단위의 금액만 입력해주세요.";
    String CONTAINS_NON_NUMERIC_VALUES = "[ERROR] 문자열을 포함시킬 수 없습니다.";
}
