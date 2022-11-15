package lotto.Constant;

public enum LottoUserValidationError {
    MONEY_MINUS(new IllegalArgumentException("[ERROR] 로또 구입 금액은 0이상이여야 합니다")),
    MONEY_NOT_DEVIDED(new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 나누어 떨어져야 합니다."));

    public IllegalArgumentException exception;
    LottoUserValidationError(IllegalArgumentException e){
        this.exception = e;
    }
}
