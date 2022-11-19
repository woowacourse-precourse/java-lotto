package lotto.constants;

public enum WinningMessage {
    FIRST("6개 일치 (2,000,000,000원) - %d개\n"),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    THIRD("5개 일치 (1,500,000원) - %d개\n"),
    FORTH("4개 일치 (50,000원) - %d개\n"),
    FIFTH("3개 일치 (5,000원) - %d개\n");

    final String message;

    WinningMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
