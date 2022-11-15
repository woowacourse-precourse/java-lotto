package lotto.domain.lottomachine.messages;

public enum DomainErrorMessage {
    LESS_THAN_SIZE_OF_SIX("[ERROR] 로또 번호의 개수는 6개여야 합니다."),
    LOTTO_NUMBERS_DUPLICATION("[ERROR] 로또 번호에 중복된 숫자가 있을 수 없습니다."),
    LESS_THAN_PRICE("[ERROR] 금액은 1000원 이상이어야 합니다."),
    NON_MULTIPLE_OF_PRICE("[ERROR] 금액은 1000원으로 나누어 떨어져야 합니다."),
    ZERO_DIVISOR("[ERROR] 0으로 나눌 수 없습니다."),
    WINNING_NUMBER_RANGE("[ERROR] 숫자는 1부터 45에 속해야 합니다."),
    WINNING_NUMBERS_DUPLICATION("[ERROR] 당첨번호는 중복될 수 없습니다."),
    BONUS_NUMBER_DUPLICATION("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다."),
    NEGATIVE_FREQUENCY("[ERROR] 빈도는 음수가 될 수 없습니다.");

    private final String message;

    DomainErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
