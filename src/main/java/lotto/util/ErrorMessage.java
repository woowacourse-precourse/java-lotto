package lotto.util;


public enum ErrorMessage {
    ERROR_MONEY_UNIT("구매 금액은 1000원 단위의 숫자만 입력 가능합니다."),
    ERROR_DUPLICATE_NUMBER("중복된 숫자입니다."),
    ERROR_INPUT_TYPE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_NUMBER_DIGIT ("6개의 숫자를 입력하세요."),
    ERROR_NEED_COMMA("6개의 숫자를 쉼표','로 구분해서 입력해주세요.");

    private static final String ERROR = "[ERROR]";
    private final String errorMessage;

    ErrorMessage(String errorMessage){
        this.errorMessage = ERROR + errorMessage;
    }
    public String getErrorMessage(){
        return this.errorMessage;
    }

}