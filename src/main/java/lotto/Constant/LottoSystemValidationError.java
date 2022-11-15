package lotto.Constant;

public enum LottoSystemValidationError {
    BONUS_RANGE(new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."));

    public IllegalArgumentException exception;
    LottoSystemValidationError(IllegalArgumentException e){
        this.exception = e;
    }
}