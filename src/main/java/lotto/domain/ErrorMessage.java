package lotto.domain;

public enum ErrorMessage {
    INPUT_EMPTY_ERROR("입력하신 값이 없습니다."),
    MONEY_NUMBER_ERROR("구입금액은 숫자여야 합니다."),
    MONEY_LIMIT_ERROR("구입금액은 2,147,483,000원 이하의 금액이어야 합니다."),
    MONEY_UNIT_ERROR("구입금액은 1000원 단위여야 합니다."),
    NEGATIVE_NUMBER_ERROR("구입금액은 양수여야 합니다."),
    ZERO_NUMBER_ERROR("0원으로는 구입할 수 없습니다."),
    NUMBER_SIZE_ERROR("로또 번호 숫자는 6개여야 합니다."),
    NOT_NUMBER_ERROR("로또 번호는 숫자여야 합니다."),
    DUPLICATE_NUMBER_ERROR("로또 번호는 중복되지 않은 숫자여야 합니다."),
    OUT_OF_RANGE_NUMBER_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    WINNING_INPUT_NUMBER_ERROR("당첨 번호는 [1,2,3,4,5,6]와 같이 입력해주세요. "),
    SEPARATOR_ERROR("당첨 번호는 쉼표(,)를 구분자로 5개 넣어주셔야 합니다."),
    BONUS_NUMBER_SIZE_ERROR("보너스 번호 숫자는 1개여야 합니다."),
    BONUS_NOT_NUMBER_ERROR("보너스 번호는 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[ERROR] " + message;
    }
}
