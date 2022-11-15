package lotto.exception;

public enum ExceptionMessages{
    ERROR("[ERROR] "),
    InvalidMoneyMessage(ERROR.getMessage() +"올바른 금액을 입력해주세요."),
    IndivisibleMoneyMessage(ERROR.getMessage() +"로또금액 단위 금액을 입력해주세요."),
    InvalidNumberMessage(ERROR.getMessage() + "숫자형식 이어야 합니다."),
    InvalidNumbersSizeMessage(ERROR.getMessage() +"로또번호는 6개 입니다."),
    DuplicateLottoNumbersMessage(ERROR.getMessage() +"서로 다른 번호만 가능합니다."),
    InvalidBonusNumberMessage(ERROR.getMessage() +"로또금액 단위 금액을 입력해주세요.");
    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}