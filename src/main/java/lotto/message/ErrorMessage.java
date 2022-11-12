package lotto.message;

public enum ErrorMessage {

    ERROR("[ERROR] "),

    MONEY_TYPE_ERROR(ERROR.getErrorMessage() + "돈은 숫자만 입력해야 됩니다."),

    MONEY_UNIT_ERROR(ERROR.getErrorMessage() + "돈은 1000원 단위로 입력해야 됩니다."),

    WINNING_NUMBER_DIGIT_ERROR(ERROR.getErrorMessage() + "당첨 번호는 콤마를 구분하여 6개의 숫자가 입력되어야 합니다."),

    WINNING_NUMBER_TYPE_ERROR(ERROR.getErrorMessage() + "당첨 번호는 숫자만 입력해야 됩니다."),

    WINNING_NUMBER_BOUNDARY_ERROR(ERROR.getErrorMessage() + "당첨 번호는 1~45 숫자 사이의 값이어야 합니다."),

    WINNING_NUMBER_DUPLICATED_ERROR(ERROR.getErrorMessage() + "당첨 번호들 끼리는 서로 겹치지 않아야 합니다."),

    BONUS_NUMBER_TYPE_ERROR(ERROR.getErrorMessage() + "보너스 번호는 숫자만 입력해야 합니다."),

    BONUS_NUMBER_BOUNDARY_ERROR(ERROR.getErrorMessage() + "보너스 번호는 1~45 사이 값을 입력해야 합니다."),

    BONUS_NUMBER_DUPLICATED_ERROR(ERROR.getErrorMessage() + "보너스 번호는 당첨 번호와 중복되지 않아야 합니다.")


    ;

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
