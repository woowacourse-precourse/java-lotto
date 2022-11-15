package lotto.domain;

public enum Error {
    bonus("[ERROR] 보너스 숫자는 1부터 45 사이의 숫자여야 합니다."),
    lotto("[ERROR] 로또 번호는 쉼표(,)로 구분된 1부터 45 사이의 6자리 숫자여야 합니다"),
    purchaseAmount("[ERROR] 구입 금액은 1,000원 단위의 숫자여야 합니다.");

    private final String value;

    Error(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
