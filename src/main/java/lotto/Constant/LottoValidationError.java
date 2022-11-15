package lotto.Constant;

public enum LottoValidationError {
    COUNT(new IllegalArgumentException("[ERROR] 로또 번호가 너무 많거나 적습니다.")),
    RANGE(new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")),
    DUPLICATE(new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있으면 안됩니다."));

    public IllegalArgumentException exception;

    LottoValidationError(IllegalArgumentException e) {
        this.exception = e;
    }
}
