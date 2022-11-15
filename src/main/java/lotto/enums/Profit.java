package lotto.enums;

import java.text.DecimalFormat;

public enum Profit {
    RATIO_OF_WINNING_TO_INSERT_MONEY("총 수익률은 %s%%입니다.");

    private final String announcement;
    private final DecimalFormat decimalFormat = new DecimalFormat("###,###.#");
    Profit(String announcement) {
        this.announcement = announcement;
    }

    public void announce(double ratio) {
        System.out.printf(announcement, decimalFormat.format(ratio));
    }

}
