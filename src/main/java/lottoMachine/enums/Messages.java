package lottoMachine.enums;

public enum Messages {
    RECEIVE_PRICE_MESSAGE("구입 금액을 입력해 주세요."),
    RECEIVE_WINNING_NUMBER_MESSAGE("\n당첨 번호를 입력해 주세요."),
    RECEIVE_BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요."),
    RESULT_OF_PURCHASE_MESSAGE("\n{0}개를 구매했습니다."),
    WINNING_STATISTICS_MESSAGE("\n당첨 통계\n"
            + "---\n"
            + "3개 일치 (5,000원) - {4}개\n"
            + "4개 일치 (50,000원) - {3}개\n"
            + "5개 일치 (1,500,000원) - {2}개\n"
            + "5개 일치, 보너스 볼 일치 (30,000,000원) - {1}개\n"
            + "6개 일치 (2,000,000,000원) - {0}개"),
    RATE_OF_RETURN_MESSAGE("총 수익률은 {0}%입니다."),
    ERROR_MESSAGE_PREFIX("[ERROR] "),
    NUMBER_RANGE_ERROR_MESSAGE("번호는 1부터 45 사이의 숫자여야 합니다."),
    PRICE_UNIT_ERROR_MESSAGE("금액은 1000원 단위 숫자여야 합니다."),
    PRICE_RANGE_ERROR_MESSAGE("금액은 1000 ~ 2147483000 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_COUNT_ERROR_MESSAGE("로또 번호는 6개의 서로 다른 숫자여야 합니다."),
    BONUS_NUMBER_COUNT_ERROR_MESSAGE("보너스 번호는 1개의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    WINNING_NUMBER_FORMAT_ERROR_MESSAGE("당첨 번호 입력 형식은 1,2,3,4,5,6 입니다.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
