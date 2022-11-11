package lotto.Domain;

public enum ErrorMessage {
    NOTONETOFOURTHYFIVE(" 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOTTHOUSANDSNUMBER(" 입력된 돈은 1000 단위 숫자여야 합니다.");

    private final String errorMessage;
    ErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage(){ return errorMessage;}
}
