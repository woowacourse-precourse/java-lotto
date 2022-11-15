package lotto.Model;

public enum ErrorResponse {

    INVALID_MONEY("[ERROR] 구입 금액은 정수로만 이루어져야 합니다."),
    INVALID_LOTTO_PURCHASE_PRICE("[ERROR] 구입 금액은 1000원 단위어야 합니다."),
    INVALID_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_SIZE("[ERROR] 로또는 6개의 번호로 이루어져야 합니다."),
    INVALID_UNIQUE_NUMBER("[ERROR] 로또의 각 번호는 중복되어서는 안됩니다.");

    private final String message;
    ErrorResponse(String message) {
        this.message = message;
    }

    public String toString(){
        return message;
    }

    private static final int LOTTO_PRICE = 1000;
}
