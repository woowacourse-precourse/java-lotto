package lotto.view;

import lotto.domain.LottoRank;

public enum StaticsView {

    MATCH("%s개 일치 (%s원) - %s개"),
    MATCH_WITH_BONUS_NUMBER("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    ;

    private final String format;

    StaticsView(String format) {
        this.format = format;
    }

    public static StaticsView getView(boolean hasBonusNumber) {
        if (hasBonusNumber) {
            return MATCH_WITH_BONUS_NUMBER;
        }

        return MATCH;
    }

    public String render(LottoRank rank, int count) {
        return String.format(format, rank.getMatchCount(), rank.getPrizeMoney(), count);
    }
}
