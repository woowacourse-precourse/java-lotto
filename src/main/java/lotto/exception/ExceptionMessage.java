package lotto.exception;

public enum ExceptionMessage {
    INPUT_ERROR("[ERROR] 입력금액은 1000원단위여야 합니다."),
    OUT_OF_RANGE_ERROR("[ERROR] 1~45사이의 숫자여야합니다."),
    DUPLICATED_ERROR("[ERROR] 서로 다른 숫자를 입력해야합니다."),
    NOT_NUMBER_ERROR("[ERROR] 공백 없이 ,와 숫자를 입력해야합니다."),
    WRONG_COUNT_ERROR("[ERROR] 6개의 숫자를 입력해야합니다.");
    public String error;

    ExceptionMessage(String error){
        this.error = error;
    }
}
