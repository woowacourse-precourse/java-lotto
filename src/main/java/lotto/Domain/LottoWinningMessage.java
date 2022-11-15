package lotto.Domain;

public enum LottoWinningMessage {
    FIFTH_PLACE("3개 일치 (5,000원) - %d개"),
    FOURTH_PLACE("4개 일치 (50,000원) - %d개"),
    THIRD_PLACE("5개 일치 (1,500,000원) - %d개"),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_PLACE("6개 일치 (2,000,000,000원) - %d개");

    private String winningMessage;

    LottoWinningMessage(String winningMessage) {
        this.winningMessage = winningMessage;
    }

    public String getWinningMessage() {
        return winningMessage;
    }
}
