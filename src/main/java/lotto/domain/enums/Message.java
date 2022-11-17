package lotto.domain.enums;

public enum Message {

    NOT_NUMBER_REGEX("\\D"),
    COMMA(","),

    RESULT_FIFTH("3개 일치 (5,000원) - "),
    RESULT_FOURTH("4개 일치 (50,000원) - "),
    RESULT_THIRD("5개 일치 (1,500,000원) - "),
    RESULT_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    RESULT_FIRST("6개 일치 (2,000,000,000원) - "),

    NOT_THOUSAND_UNIT_INPUT_ERROR("[ERROR] 잘못 입력하셨습니다.\n입력 금액은 1,000원 단위의 숫자입니다."),
    INPUT_WINNING_NUMBER_ERROR("[ERROR] 잘못 입력하셨습니다.\n1부터 45 사이의 6자리수를 중복되지 않게 쉼표(,)를 이용하여 입력해주세요.\n예) 1,2,3,4,5,6"),
    BONUS_NUMBER_INPUT_ERROR("[ERROR] 보너스 번호는 로또 번호와 중복되지 않는 1에서 45 사이의 하나의 숫자입니다."),

    INPUT_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    TOTAL_RESULT_MESSAGE("\n당첨 통계\n---"),
    END_PROGRAM_MESSAGE("로또 프로그램을 종료합니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
