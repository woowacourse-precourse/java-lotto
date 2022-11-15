package lotto.utils;

public enum ErrorMessage {
    INPUT_EMPTY_ERROR("입력하신 값이 없습니다."),
    MONEY_NUMBER_ERROR("구입금액은 양의 정수만 있어야 합니다."),
    MONEY_LIMIT_ERROR("구입금액은 2,147,483,000원 이하의 금액이어야 합니다."),
    MONEY_UNIT_ERROR("구입금액은 1000원 단위여야 합니다."),
    UNDER_MONEY_ERROR("구입금액은 1000원 이상이어야 합니다."),
    NUMBER_SIZE_ERROR("로또 번호는 숫자 6개여야 합니다."),
    NOT_NUMBER_ERROR("로또 번호는 양의 정수와 구분자 쉼표(,)만 있어야 합니다."),
    DUPLICATE_NUMBER_ERROR("로또 번호는 중복되지 않은 숫자여야 합니다."),
    OUT_OF_RANGE_NUMBER_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    WINNING_INPUT_NUMBER_ERROR("당첨 번호는 [1,2,3,4,5,6]와 같이 입력해주세요."),
    SEPARATOR_ERROR("당첨 번호는 쉼표(,)를 구분자로 5개 넣어주셔야 합니다."),
    BONUS_NOT_NUMBER_ERROR("보너스 번호는 양의 정수만 있어야 합니다."),
    BONUS_NUMBER_DUPLICATED_ERROR("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");

    private static final String ERROR_FORMAT = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR_FORMAT + message;
    }
}