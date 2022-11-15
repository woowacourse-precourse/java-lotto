package lotto;

public enum ErrorMsg {
    IO_ERR_MSG("[ERROR] 잘못된 입력입니다."),
    NUM_FORMAT_MSG("[ERROR] 숫자가 아닌 입력이 있습니다."),
    NUM_CONTAIN_MSG("[ERROR] 중복된 숫자 입니다."),
    SIZE_UP_MSG("[ERROR] 6개의 숫자만 입력가능합니다."),
    NUM_RANGE_MSG("[ERROR] 유요한 숫자 범위가 아닙니다.");

    private final String errorMsg;

    ErrorMsg(String str) {
        this.errorMsg = str;
    }

    public String getErrorMsg(){
        return this.errorMsg;
    }
}
