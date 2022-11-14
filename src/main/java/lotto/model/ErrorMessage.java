package lotto.model;

public enum ErrorMessage {
    NOT_STRING_ERROR_MESSAGE("[ERROR] 로또 금액은 숫자여야 합니다."),
    NOT_DIVIDED_BY_THOUSAND_ERROR_MESSAGE("[ERROR] 1000원 단위로만 입력할 수 있습니다."),
    INVALID_LOTTO_NUMBER_ERROR_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    WINNING_BONUS_NUMBER_DUPLICATED_ERROR_MESSAGE("[ERROR] 당첨 번호와 보너스 번호가 중복되었습니다.");

    private final String message;

    ErrorMessage (String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
