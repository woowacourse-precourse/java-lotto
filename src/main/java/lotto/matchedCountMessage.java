package lotto;

public enum matchedCountMessage {
    THREE_MATCH("3개 일치 (5,000원) -"),
    FOUR_MATCH("4개 일치 (50,000원) -"),
    FIVE_MATCH("5개 일치 (1,500,000원) -"),
    FIVE_MATCH_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) -"),
    SIX_MATCH("6개 일치 (2,000,000,000원) -");

    private String matchedMessage;
    matchedCountMessage(String string) {
        this.matchedMessage = string;
    }

    public String getMatchMessage() {
        return this.matchedMessage;
    }

}
