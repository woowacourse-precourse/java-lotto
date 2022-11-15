package lotto.Model;

public enum ErrorResponse {

    INVALID_MONEY("[ERROR] 구입 금액은 정수로만 이루어져야 합니다."),
    INVALID_LOTTO_PURCHASE_PRICE("[ERROR] 구입 금액은 1000원 단위어야 합니다."),
    INVALID_LOTTO_NUMBER("[ERROR] 로또의 번호는 1부터 45 사이의 정수여야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또의 번호는 1부터 45 사이의 값이어야 합니다."),

    INVALID_LOTTO_SIZE("[ERROR] 로또는 6개의 번호로 이루어져야 합니다."),
    INVALID_UNIQUE_NUMBER("[ERROR] 로또의 각 번호는 중복되어서는 안됩니다."),
    INVALID_WINNING_NUMBERS("[ERROR] 당첨 번호는 각각 쉼표를 기준으로 구분된 6개의 입력 값이어야 합니다."),
    INVALID_WINNING_UNIQUE_NUMBERS("[ERROR] 당첨 번호 6개는 중복되어서는 안 됩니다."),
    INVALID_BONUS_UNIQUE_NUMBER("[ERROR] 보너스 번호는 당첨 번호 6개와는 다른 수여야 합니다.");


    private final String message;
    ErrorResponse(String message) {
        this.message = message;
    }

    public String toString(){
        return message;
    }
}
