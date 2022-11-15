package lotto.view;// @ author ninaaano

public enum ErrorMessage {
    DUPLICATE(new IllegalArgumentException("[ERROR] 중복된 값 입니다.")),
    STRINGEXCEPTION(new IllegalArgumentException("[ERROR] 입력값에 문자열이 들어올 수 없습니다.")),
    OUTOFRANGE(new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")),
    AMOUNTBOUNDS(new IllegalArgumentException("[ERROR] 잘못된 입력값입니다.")),
    LENGTHBOUNDS(new IllegalArgumentException("[ERROR] 갯수가 올바르지 않습니다"))
    ;

    private IllegalArgumentException error;

    ErrorMessage(IllegalArgumentException error) {
        this.error = error;
    }

    public IllegalArgumentException getError() {
        return error;
    }
}
