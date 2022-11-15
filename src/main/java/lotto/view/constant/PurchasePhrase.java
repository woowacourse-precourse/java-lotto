package lotto.view.constant;

public enum PurchasePhrase {
    PURCHASE("%d개를 구매했습니다."),
    LOTTERY_NUMBER("[%d, %d, %d, %d, %d, %d]");

    private final String phrase;

    private PurchasePhrase (String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }
}
