package lotto;

public enum Message {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    PURCHASE("개를 구매했습니다."),
    WIN_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_INPUT("보너스 번호를 입력해 주세요."),
    WIN_STATISTICS("당첨 통계"),
    WIN_5TH("3개 일치 (5,000원) - "),
    WIN_4TH("4개 일치 (50,000원) - "),
    WIN_3TH("5개 일치 (1,500,000원) - "),
    WIN_2TH("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    WIN_1TH("6개 일치 (2,000,000,000원) - ");

    private final String message;

    Message(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
