package view;

public enum Message {

    THREE("3개 일치 (5,000원) - "),
    FOUR("4개 일치 (50,000원) - "),
    FIVE("5개 일치 (1,500,000원) - "),
    FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX("6개 일치 (2,000,000,000원) - "),
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    BUY("개를 구매했습니다."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요. "),
    BONUS_NUMBER("보너스 번호를 입력해 주세요. "),
    STATISTICS("당첨 통계 "),
    YIELD("총 수익률은 ");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
