package lotto.global.message;

public interface ErrorMessage {

    String NEGATIVE_NUMBER = "[ERROR] 양수만 입력해주세요.";
    String NOT_INPUT_MONEY = "[ERROR] 금액을 입력하지 않았습니다.";
    String NOT_IN_THOUSANDS_OF_NUMBER = "[ERROR] 금액이 천원 단위가 아닙니다.";
    String IS_NOT_INTEGER = "[ERROR] 숫자가 아닙니다.";
}
