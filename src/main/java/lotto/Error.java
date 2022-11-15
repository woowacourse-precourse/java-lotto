package lotto;

public enum Error {
    NumberError("[ERROR] 금액은 숫자만 허용됩니다."),
    UnitError("[ERROR] 금액은 1000원 단위입니다."),
    RangeError("[ERROR] 로또는 1-45사이 숫자입니다"),
    CountError("[ERROR] 로또는 숫자 6자리 입니다."),
    MultiError("[ERROR] 로또 숫자는 중복되면 안됩니다."),
    BonusRangeError("[ERROR] 보너스 숫자는 1-45사이 하나의 숫자입니다"),
    BonusMultiError("[ERROR] 로또 숫자는 중복되면 안됩니다(보너스 점수 중복).");


    private final String message;

    Error(String message) {
        this.message = message;
    }
    public String print(){
        return message;
    }
}
