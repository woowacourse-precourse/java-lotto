package lotto.Enums;

public enum ErrorMessage {

    PRICE_TYPE("[ERROR] 구입 금액은 숫자여야 합니다."),
    PRICE_MOD("[ERROR] 구입 금액은 1000으로 나뉘어 떨어져야 합니다."),
    WINNUM_LENGTH("[ERROR] 당첨 번호는 6개여야 합니다."),
    WINNUM_TYPE("[ERROR] 당첨 번호는 슷자여야 합니다."),
    WINNUM_RANGE("[ERROR] 당첨 번호는 1~45사이의 수여야 합니다."),
    WINNUM_DUPLICATE("[ERROR] 당첨 번호는 모두 다른 숫자로 이루어져야 합니다."),
    BONUS_TYPE("[ERROR]  보너스 번호는 숫자여야 합니다."),
    BONUS_RANGE("[ERROR] 보너스 번호는 1~45사이의 수여야 합니다."),
    BONUS_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private String message;
    ErrorMessage(String message) {this.message = message;}

    public String getMessage() {return message;}

}
