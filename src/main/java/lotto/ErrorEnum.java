package lotto;

public enum ErrorEnum {

    BAD_REQUEST_MONEY_NOT1000_EXCEPTION("[ERROR] 1000원으로 나누어떨어지지 않음"),
    BAD_REQUEST_DUPLICATED_NUM_EXCEPTION("[ERROR] 로또 번호가 중복되었습니다."),
    BAD_REQUEST_NOT_VALID_NUM_EXCEPTION("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private
    final String message;

    ErrorEnum(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
