package lotto.view;

public enum MatchMessage {
    THREE("3개 일치 (5,000원) - %d개"),
    FOUR("4개 일치 (50,000원) - %d개"),
    FIVE("5개 일치 (1,500,000원) - %d개"),
    FIVE_AND_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX("6개 일치 (2,000,000,000원) - %d개");

    private final String message;

    MatchMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}

