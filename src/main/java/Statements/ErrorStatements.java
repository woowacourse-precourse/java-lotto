package statements;

public enum ErrorStatements {

    SHOUT_DUPLICATED_NUMBERS("[ERROR] 중복된 숫자가 있습니다. 당첨 번호를 다시 입력해주세요"),
    SHOUT_NOT_NUMBER_ERROR("[ERROR] 숫자가 아닌 입력값이 있습니다. 숫자를 입력해주세요."),
    SHOUT_NUMBER_RANGE_ERROR("[ERROR] 범위를 넘어선 숫자입니다. 1~45사이의 숫자를 입력해주세요."),
    SHOUT_INVALID_FORMAT_ERROR("[ERROR] 유효하지 않은 형식입니다. 형식에 맞는 값을 입력해주세요."),
    SHOUT_INVALID_LENGTH_ERROR("[ERROR] 유효하지 않은 입력입니다. 길이에 맞는 값을 입력해주세요."),
    SHOUT_PAYMENT_UNIT_ERROR("[ERROR] 가격 단위가 부적절합니다. 1000원 단위로 입력해주세요."),
    SHOUT_BONUS_SHOUlD_NOT_BE_SAME("[ERROR] 보너스 숫자는 당첨 숫자와 중복될 수 없습니다. 다시 입력해주세요"),
    SHOUT_NO_PAY_NO_GAME("[ERROR] 로또를 살 수 없는 금액입니다. 로또의 한 장의 가격은 1000원 입니다."),
    EXIT_PROGRAM("프로그램을 종료합니다.");
    private final String warning;
    private ErrorStatements(String warning){
        this.warning=warning;
    }

    public String alarmed(){
        return warning;
    }

}
