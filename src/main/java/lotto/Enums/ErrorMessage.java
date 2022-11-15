package lotto.Enums;

public enum ErrorMessage {

    INPUT_TYPE("[ERROR] 입력값은 숫자여야 합니다."),
    PRICE_MOD("[ERROR] 구입 금액은 1000으로 나뉘어 떨어져야 합니다."),
    Lotto_LENGTH("[ERROR]  로또 번호는 6개여야 합니다."),
    Lotto_DUPLICATE("[ERROR] 로또 번호는 모두 다른 숫자로 이루어져야 합니다."),
    Lotto_RANGE("[ERROR] 로또 번호는 1~45사이의 수여야 합니다."),
    BONUS_RANGE("[ERROR] 보너스 번호는 1~45사이의 수여야 합니다."),
    BONUS_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private String message;
    ErrorMessage(String message) {this.message = message;}

    public String getMessage() {return message;}

}
