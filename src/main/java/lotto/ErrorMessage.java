package lotto;

public enum ErrorMessage {

    PurchaseStr("[ERROR] 구입금액이 잘못 입력되었습니다."),
    OverlapExist("[ERROR] 로또 번호 중 중복된 값이 있습니다."),
    PurchaseThousandError("[ERROR] 1,000원 단위로만 구매하실 수 있습니다."),
    LottoOver("[ERROR] 로또의 개수는 6개 입니다."),
    LottoNotSix("[ERROR] 당첨 로또 번호의 갯수가 맞지 않습니다. "),
    LottoNumberStr("[ERROR] 로또 번호는 숫자 6개로 이루어져 있습니다.")
    ;





    private final String msg;
    ErrorMessage(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return msg;
    }
}
