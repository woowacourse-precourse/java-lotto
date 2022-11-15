package lotto.view;

public enum ErrorMessages {
    PREFIX("[ERROR] "),
    NUMBER_ELEMENT("구입 금액은 0 이상의 숫자만 입력 받습니다."),
    MONETARY_UNIT("구입 금액은 1,000원 단위로 입력 받습니다."),
    WINNING_NUMBER("당첨 번호를 형식에 맞게 입력하지 않았습니다."),
    WINNING_DELIMITER("당첨 번호의 구분자가 잘못 입력 되었습니다."),
    BONUS_NUMBER("보너스 번호가 숫자가 아닙니다."),
    BONUS_NUMBER_RANGE("보너스 번호가 범위에 맞게 들어오지 않았습니다."),
    DUPLICATED_BONUS_NUMBER("보너스 번호가 당첨 번호와 중복됩니다."),
    PURCHASED_TICKET_COUNTS("\n%d개를 구매했습니다.");


    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }

}
