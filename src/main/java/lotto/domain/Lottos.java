package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.util.Constants.*;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public String getLottosString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.getNumbersString());
            sb.append(RESULT_SEPARATOR);
        }
        return sb.toString().trim();
    }

    public Map<RankingType, Integer> getRankingTypeCounts(WinningLotto winningNumber) {
        Map<RankingType, Integer> rankingTypeCounts = getInitRankingTypeCounts();

        List<RankingType> lottosRankingTypes = getLottosRankingTypes(winningNumber);

        updateRankingTypeCounts(rankingTypeCounts, lottosRankingTypes);
        return rankingTypeCounts;
    }

    private Map<RankingType, Integer> getInitRankingTypeCounts() {
        Map<RankingType, Integer> rankingTypeCounts = new HashMap<>();
        RankingType[] values = RankingType.values();
        for (RankingType value : values) {
            rankingTypeCounts.put(value, INIT_COUNT);
        }
        return rankingTypeCounts;
    }

    private List<RankingType> getLottosRankingTypes(WinningLotto winningNumber) {
        List<RankingType> lottosRankingTypes = new ArrayList<>();

        for (Lotto lotto : lottos) {
            RankingType rankingType = lotto.getRankingType(winningNumber);
            lottosRankingTypes.add(rankingType);
        }
        return lottosRankingTypes;
    }

    private static void updateRankingTypeCounts(Map<RankingType, Integer> rankingTypeCounts,
                                                List<RankingType> lottosRankingTypes) {
        for (RankingType rankingType : lottosRankingTypes) {
            int originCount = rankingTypeCounts.get(rankingType);
            rankingTypeCounts.put(rankingType, originCount + VALUE_FOR_UPDATE_COUNT);
        }
    }
}
