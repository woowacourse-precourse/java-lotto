package lotto.ui;

public enum ConsoleMessage {
    // 입력 관련
    INPUT_PRICE("구입금액을 입력해 주세요."),
    INPUT_WINNING_LOTTOS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    // 입력 형식 오류
    INVALID_INPUT_PRICE("잘못된 형식의 금액을 입력하셨습니다."),
    INVALID_INPUT_WINNING_LOTTO("잘못된 형식으로 당첨 번호를 입력 했습니다."),
    INVALID_INPUT_BONUS_NUMBER("잘못된 형식의 보너스 번호를 입력하셨습니다."),
    BONUS_NUMBER_DUPLICATE("보너스 번호는 당첨 번호와 중복된 값이 올 수 없습니다."),

    // 로또 번호 validation 오류
    INVALID_LOTTO_SIZE("로또 번호 개수는 6개로 제한됩니다."),
    LOTTO_NUMBER_DUPLICATE("로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1 ~ 45 사이의 수여야 합니다."),

    // 최종 통계 결과 출력
    SIX_MATCHES("6개 일치"),
    FIVE_MATCHES_PLUS_BONUS("5개 일치, 보너스 볼 일치"),
    FIVE_MATCHES("5개 일치"),
    FOUR_MATCHES("4개 일치"),
    THREE_MATCHES("3개 일치");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

}
