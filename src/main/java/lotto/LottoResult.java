package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static lotto.LottoFactory.LOTTO_MIN_NUMBER;
import static lotto.WinningNumber.REPEAT_INITIAL_VALUE;

public class LottoResult {

    private final static int INITIAL_VALUE = 0;
    private final Map<Ranking, Integer> lottoResult = new EnumMap<>(Ranking.class);

    public LottoResult(List<Ranking> ranks) {
        Ranking[] temp = Ranking.values();
        for (Ranking ranking : temp) {
            lottoResult.put(ranking, REPEAT_INITIAL_VALUE);
        }
        for (Ranking ranking : ranks) {
            lottoResult.put(ranking, lottoResult.getOrDefault(ranking, REPEAT_INITIAL_VALUE) + LOTTO_MIN_NUMBER);
        }
    }

    public int checkWinningNumberPrizeMoney() {
        int prizeMoney = INITIAL_VALUE;
        for (Ranking ranking : lottoResult.keySet()) {
            int winningCount = lottoResult.get(ranking);
            prizeMoney += ranking.getPrizeMoney() * winningCount;
        }
        return prizeMoney;
    }

    public Set<Map.Entry<Ranking, Integer>> entrySet() {
        return lottoResult.entrySet();
    }

    public Map<Ranking, Integer> getLottoResult() {
        return lottoResult;
    }

}