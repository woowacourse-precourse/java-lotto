package lotto.enums;

public enum PrintMsg {
    LINE_BREAK("\n"),
    INPUT_PURCHASE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_PURCHASE_LOTTO("개를 구매했습니다."),
    OUTPUT_WINNING_RESULT("당첨 통계\n---"),
    OUTPUT_COUNT("개"),
    OUTPUT_TOTAL_YIELD("총 수익률은 "),
    OUTPUT_POSTFIX("%입니다."),
    ERROR_PREFIX("[ERROR] "),
    ERROR_INPUT_VALUE_IS_NOT_NUMBER("입력은 숫자 형식이어야 합니다."),
    ERROR_PURCHASE_AMOUNT_IS_NOT_DIVIDED_BY_1000("구입 금액은 1,000원 단위로 입력해야 합니다."),
    ERROR_WINNING_NUMBER_INPUT_IS_INVALID_INPUT_TYPE("입력은 쉼표(,)를 기준으로 한 숫자 형식이어야 합니다."),
    ERROR_WINNING_NUMBER_IS_NOT_SIX("당첨 번호가 6개보다 많거나 적은 수의 번호를 가지고 있습니다. 당첨 번호는 6개만 입력해야 합니다."),
    ERROR_WINNING_NUMBER_IS_NOT_BETWEEN_1_AND_45("당첨 번호는 1~45 사이의 숫자만 입력이 가능합니다."),
    ERROR_WINNING_NUMBER_IS_DUPLICATED("당첨 번호는 중복이 없도록 입력해야 합니다."),
    ERROR_BONUS_NUMBER_IS_NOT_BETWEEN_1_AND_45("보너스 번호는 1~45 사이의 숫자만 입력이 가능합니다."),
    ERROR_BONUS_NUMBER_IS_NOT_CONTAINED_WINNING_NUMBER("보너스 번호는 당첨 번호와 겹치지 않는 숫자로 입력해야 합니다."),
    ERROR_LOTTO_NUMBER_IS_NOT_SIX("로또가 6개보다 많거나 적은 수의 번호를 가진 채 발행됐습니다."),
    ERROR_LOTTO_NUMBER_IS_DUPLICATED("로또가 중복된 번호로 발행됐습니다."),
    ERROR_LOTTO_NUMBER_IS_NOT_BETWEEN_1_AND_45("로또가 1에서 45의 범위를 벗어난 번호를 가진 채 발행됐습니다.");

    private final String message;

    PrintMsg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}