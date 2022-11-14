package lotto;

import java.util.EnumMap;

public class LottoResult {
    private EnumMap<Match, Integer> lottoMatch = new EnumMap<>(Match.class);

    public void plusLottoResult(Match match) {
        int count = getLottoMatchCountByKey(match);
        lottoMatch.put(match, count + 1);
    }

    public double getPrizeMoney() {
        double total = 0;

        total += calculateWinnings(Match.THREE);
        total += calculateWinnings(Match.FOUR);
        total += calculateWinnings(Match.FIVE);
        total += calculateWinnings(Match.SIX);
        total += calculateWinnings(Match.FIVE_WITH_BONUS);

        return total;
    }

    private int calculateWinnings(Match match) {
        return getLottoMatchCountByKey(match) * match.getPrice();
    }

    public int getLottoMatchCountByKey(Match match) {
        return lottoMatch.getOrDefault(match, 0);
    }
}
