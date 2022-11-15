package lotto.domain;

import java.text.DecimalFormat;

public enum Rank {
    FIRST("6개 일치 (%s원) - %d개", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치 (%s원) - %d개", 30000000),
    THIRD("5개 일치 (%s원) - %d개", 1500000),
    FOURTH("4개 일치 (%s원) - %d개", 50000),
    FIFTH("3개 일치 (%s원) - %d개", 5000);

    private final String message;
    private final int prize;

    Rank(String message, int prize) {
        this.message = message;
        this.prize = prize;
    }

    public int getPrize() {
        return this.prize;
    }

    public String getMessage(int count) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        return String.format(this.message, decFormat.format(this.prize), count);
    }
}
