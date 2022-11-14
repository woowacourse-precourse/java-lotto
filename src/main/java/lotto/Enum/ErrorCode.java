package lotto.Enum;

public enum ErrorCode {

    NOT_NUMBER("[ERROR] 구입금액은 숫자만 입력해야합니다."),
    NOT_SIX_SIZE("[ERROR] 로또번호는 6개로 입력해주세요"),
    NOT_IN_LOTTO_RANGE("[ERROR] 로또번호는 1부터 45사이입니다."),
    DUPLICATION_NUMBER("[ERROR] 로또 번호에 중복된 숫자가 있습니다."),
    NOT_DIVIDE_1000("[ERROR] 돈은 1000원 단위로 떨어져야 합니다."),
    NOT_ONE_NUMBER("[ERROR] 입력값이 한자리의 숫자가 아닙니다."),
    INVALID_INPUT("[ERROR] 입력값이 잘못됐습니다.");


    private final String errorMessage;
    ErrorCode(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getMessage(){
        return this.errorMessage;
    }
}
