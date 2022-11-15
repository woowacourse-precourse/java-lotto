package lotto;

public enum Error {
    COST_ERROR                  ("1,000 단위의 금액만 구입 가능합니다"),
    NOT_NUMERIC_ERROR           ("숫자만 입력 가능합니다"),
    LOTTO_LENGTH_ERROR          ("로또 번호는 6자리여야 합니다"),
    LOTTO_NUM_DUPLICATE_ERROR   ("로또 번호는 중복될 수 없습니다"),
    RANGE_ERROR                 ("로또 번호는 1~45사이만 가능합니다.");

    private static final String ERROR_MESSAGE = "[ERROR]";
    private final String errorMessage;

    Error(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public void wrongInput(){
        System.out.println(ERROR_MESSAGE + this.errorMessage);
        throw new IllegalArgumentException(ERROR_MESSAGE + this.errorMessage);
    }
}
