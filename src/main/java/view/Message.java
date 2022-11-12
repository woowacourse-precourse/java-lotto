package view;

public enum Message {

    START("구입금액을 입력해 주세요."),
    TOTAL("개를 구매했습니다."),
    INPUT("당첨 번호를 입력해 주세요. "),
    BONUS("보너스 번호를 입력해 주세요. "),
    STATISTICS("당첨 통계 "),
    THREE("3개 일치 (5,000원) - "),
    FOUR("4개 일치 (50,000원) - "),
    FIVE("5개 일치 (1,500,000원) -"),
    FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) -"),
    SIX("6개 일치 (2,000,000,000원) - ");

    private final String message;

    private Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
