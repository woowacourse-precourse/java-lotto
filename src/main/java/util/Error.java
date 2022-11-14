package util;

public enum Error {
    NUMBER("[ERROR] 숫자를 입력하셔야 합니다."),
    DIVIDE("[ERROR] 금액이 1000원 단위로 나누어 떨어지지 않습니다."),
    RANGE("[ERROR] 로또 번호는 1~45 사이의 숫자여야합니다."),
    WINNUMBER("[ERROR] 당첨번호는 숫자와 쉼표만 입력 가능합니다."),
    SAMENUMBER("[ERROR] 동일 숫자가 있는지, 숫자가 여섯개인지 확인해주세요."),
    SAMEBONUSNUMBER("[ERROR] 당첨 번호 중 보너스 번호와 동일한 숫자가 있습니다.");

    private final String errorMsg;

    Error(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
