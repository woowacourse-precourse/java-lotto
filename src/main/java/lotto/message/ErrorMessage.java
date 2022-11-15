package lotto.message;

public enum ErrorMessage {
    Purchase_Price("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다."),
    Lotto_Numbers_Size("[ERROR] 로또 번호는 6개의 숫자를 입력해야 합니다."),
    Lotto_Numbers_Range("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    Lotto_Numbers_Duplicate("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다."),
    Lotto_Numbers_Not("[ERROR] 숫자 혹은 쉼표(,)가 아닌 다른 값은 입력할 수 없습니다."),
    Bonus_Not("[ERROR] 보너스 번호를 잘못 입력하셨습니다."),
    Bonus_Range("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    Bonus_Duplicate("[ERROR] 보너스 번호는 로또 번호와 중복되지 않는 숫자여야 합니다."),
    Not_Digit("[ERROR] 숫자가 아닌 다른 값은 입력할 수 없습니다.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
