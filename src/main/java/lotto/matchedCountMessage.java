package lotto;

public enum matchedCountMessage {
    THREE_MATCH("3개 일치 (5,000원) -", 3),
    FOUR_MATCH("4개 일치 (50,000원) -", 4),
    FIVE_MATCH("5개 일치 (1,500,000원) -",5),
    SIX_MATCH("6개 일치 (2,000,000,000원) -",6),
    FIVE_MATCH_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) -", 7);


    private String matchedMessage;
    private int number;

    matchedCountMessage(String string, int number) {
        this.matchedMessage = string;
        this.number = number;
    }

    public String getMatchMessage() {
        return this.matchedMessage;
    }
    public int getMatchNumber() {
        return this.number;}

}
