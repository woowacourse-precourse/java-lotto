package lotto.domain;

public enum ErrorMessages {
    OUT_OF_RANGE( "[ERROR] 이 입력은 " + Constants.MINIMUM_LOTTO_NUMBER.getValue() + "와 "
            + Constants.MAXIMUM_LOTTO_NUMBER.getValue() + "사이의 정수여야 합니다."),
    DUPLICATE("[ERROR] 이 입력은 당첨 번호들과 중복이 되지 않는 수여야 합니다."),
    WRONG_SIZE("[ERROR] 이 입력은 정확히 " + Constants.NUMBER_TO_DRAW.getValue() + "개의 정수여야 합니다."),
    INDIVISIBLE("[ERROR] 구매 금액은 " + Constants.PRICE.getValue() + "로 나누어 떨어지는 정수여야 합니다."),
    NOT_INTEGER("[ERROR] 이 입력은 정수여야 합니다."),
    CANNOT_SPLIT("[ERROR] 이 입력은 ','로 구분되는 정수들의 나열이어야 합니다.");
    private String message;
    ErrorMessages (String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
