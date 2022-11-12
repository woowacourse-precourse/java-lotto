package lotto.util;

public enum ErrorMessages {
    HAS_OVERLAP_NUMBER("[ERROR] 중복된 값이 있습니다."),
    LESS_THAN_SIX("[ERROR] 6개의 숫자를 입력해야 합니다."),
    MORE_THAN_SIX("[ERROR] 6개의 숫자를 입력해야 합니다."),
    WRONG_SEPARATOR("[ERROR] 쉼표를 통해 구분해야합니다."),
    NOT_NUMBER_EXIST("[ERROR] 숫자만 입력해야 합니다."),
    OUT_OF_BOUND("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_SINGLE_NUMBER("[ERROR] 숫자를 한 개만 입력해야 합니다."),
    MONEY_UNDIVIDED("[ERROR] 1,000원 단위로만 구매해야 합니다."),
    BELOW_THE_PRICE_THRESHOLD("[ERROR] 최소 구매 가능액은 1,000원 입니다.");


    private final String errorMessage;

    ErrorMessages(String errorMessage){
        this.errorMessage = errorMessage ;
    }
    public String getMessage(){
        return this.errorMessage;
    }
}
