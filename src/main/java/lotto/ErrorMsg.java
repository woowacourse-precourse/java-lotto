package lotto;

public enum ErrorMsg {
    ERRMSG("[ERROR]");
    private String errMsg;
    private ErrorMsg(String errMsg) {
        this.errMsg = errMsg;
    }
    public String getErrMsg() {
        return this.errMsg;
    }
}
