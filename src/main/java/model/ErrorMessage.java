package model;

public enum ErrorMessage {
    OVERSIZE_ERROR_MESSAGE("[ERROR] 로또는 6자리여야 합니다."),
    DUPLICATE_ERROR_MESSAGE("[ERROR] 중복된 번호의 입력은 불가능합니다."),
    DUPLICATE_BONUS_MESSAGE("[ERROR] 보너스 번호는 당첨 번호와 중복 불가능합니다."),
    OVERRANGE_ERROR_MESSAGE("[ERROR] 1부터 45 사이 숫자만 입력 가능합니다."),
    NOT1000MONEY_ERROR_MESSAGE("[ERROR] 1000원 단위로만 구매하실 수 있습니다."),
    NOTDIGIT_ERROR_MESSAGE("[ERROR] 로또 번호는 숫자만 입력 가능합니다."),
    NOTDIGIT_NOTCOMMA("[ERROR] 숫자와 , 형식으로 입력 해 주세요.");

    private final String errorMessage;

    ErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
