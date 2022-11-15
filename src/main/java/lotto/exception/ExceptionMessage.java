package lotto.exception;

public enum ExceptionMessage {
    INPUT_ERROR("[ERROR] 입력금액은 1000원단위여야 합니다."),
    OUT_OF_RANGE_ERROR("[ERROR] 1~45사이의 숫자여야합니다."),
    DUPLICATED_ERROR("[ERROR] 서로 다른 숫자를 입력해야합니다."),
    NOT_NUMBER_ERROR("[ERROR] 공백 없이 ,와 숫자를 입력해야합니다."),
    WRONG_COUNT_ERROR("[ERROR] 6개의 숫자를 입력해야합니다."),
    ZERO_START_ERROR("[ERROR] 숫자가 0부터 시작하면 안됩니다."),
    NOT_BUY_LOTTO_ERROR("[ERROR] 1개 이상의 로또를 구매해 주세요."),
    BONUS_IN_WINNING_ERROR("[ERROR] 보너스 번호가 당첨번호 안에 있으면 안된다."),
    INPUT_LIMIT_ERROR("[ERROR] 로또는 인당 100,000원 이하로 살 수 있습니다.");
    public String error;

    ExceptionMessage(String error){
        this.error = error;
    }
}
