package lotto.view;

import lotto.domain.LottoRank;

import java.text.NumberFormat;
import java.util.EnumMap;
import java.util.Map;

public enum RankView {

    MATCH("%s개 일치 (%s원) - %s개\n"),
    MATCH_WITH_BONUS_NUMBER("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    ;

    private final String format;

    RankView(String format) {
        this.format = format;
    }

    public static String render(EnumMap<LottoRank, Integer> ranks) {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<LottoRank, Integer> entry : ranks.entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();

            if (rank.getMatchCount() == 0) continue;

            RankView view = RankView.getView(rank.isHasBonusNumber());
            result.append(view.render(rank, count));
        }

        return result.toString();
    }

    public static RankView getView(boolean hasBonusNumber) {
        if (hasBonusNumber) {
            return MATCH_WITH_BONUS_NUMBER;
        }

        return MATCH;
    }

    public String render(LottoRank rank, int count) {
        return String.format(
                format,
                rank.getMatchCount(),
                NumberFormat.getInstance().format(rank.getPrizeMoney()),
                count);
    }
}
