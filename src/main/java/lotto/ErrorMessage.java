package lotto;

public enum ErrorMessage {

    PREFIX("[ERROR] "),
    INPUT_NUMBER("숫자를 입력해야 합니다."),
    INPUT_PROPER_UNIT("1000원 단위로 입력해야 합니다."),
    INPUT_SIX("숫자를 여섯개 입력해야 합니다."),
    INPUT_DUPLICATE("중복되지 않은 숫자를 입력해야 합니다."),
    INPUT_RANGE("1부터 45사이의 숫자를 입력해야 합니다.");

    String msg;

    ErrorMessage(String msg) {
        this.msg = msg;
    }


    String printError() {
        return ErrorMessage.PREFIX.msg + msg;
    }
}
