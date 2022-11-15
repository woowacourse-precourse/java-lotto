package lotto;

public enum ErrorPrint {
    purchaseAmount("[ERROR] 입력은 숫자로만 이루어져 있어야 합니다."),
    lottoInput("[ERROR] 입력은 숫자와 ','으로만 이루어져 있어야 합니다."),
    amountModulo("[ERROR] 숫자는 천 단위로 이루어져 있어야 합니다."),
    bonusNumber("[ERROR] 1~45 사이의 숫자로 이루어져 있어야 합니다."),
    lottoSize("[ERROR] 로또의 길이가 6이 아닙니다"),
    lottoOverlap("[ERROR] 중복된 숫자가 포함되어 있습니다."),
    lottoNumber("[ERROR] 로또는 1~45의 숫자로 이루어져 있어야 합니다."),
    bonusNumberContain("[ERROR] 보너스 번호가 이미 당첨 로또에 포함되어 있습니다.");
    private final String errorMessage;

    ErrorPrint(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
