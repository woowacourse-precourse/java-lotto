package lotto;

public enum ErrorPrint {
    LottoSizeError("[ERROR] 로또는 6개의 숫자로 구성되어야 합니다."),
    LottoNumberError("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    AmountErrorNumberError("[ERROR] 천단위로 숫자로만 이루어져 있어야합니다.");


    private String errorCode;
    private String errorMessage;

    ErrorPrint(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
