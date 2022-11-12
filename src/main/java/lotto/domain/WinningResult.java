package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    public static final String WINNING_RESULT_MESSAGE = "%s - %d개\n";
    public static final String WINNING_RESULT_START_MESSAGE = "당첨금액\n---\n";
    private WinningNumbers winningNumbers;

    private Map<Ranking, Integer> winningResult = new EnumMap<>(Ranking.class);

    public WinningResult(Lottos lottos) {
        this.winningNumbers = new WinningNumbers();
        initialWinningResult();
        putWinningResult(lottos);
    }

    private void initialWinningResult() {
        for (Ranking ranking : Ranking.values()) {
            winningResult.put(ranking, 0);
        }
    }

    public void putWinningResult(Lottos lottos) {
        List<Ranking> rankings = winningNumbers.calculateRanking(lottos);
        for (Ranking ranking : rankings) {
            winningResult.put(ranking, winningResult.get(ranking) + 1);
        }
    }

    private String makeRankingMessage() {
        StringBuilder result = new StringBuilder();
        for (Ranking ranking : Ranking.values()) {
            result.append(makeWinningResultMessageExceptNothing(ranking));
        }
        return WINNING_RESULT_START_MESSAGE + result;
    }

    private String makeWinningResultMessageExceptNothing(Ranking ranking) {
        if (ranking != Ranking.NOTHING) {
            return String.format(WINNING_RESULT_MESSAGE, ranking.toString(), winningResult.get(ranking));
        }
        throw new IllegalArgumentException("[ERROR] 올바른 당첨 기준을 찾을 수 없습니다.");
    }

    @Override
    public String toString() {
        return makeRankingMessage();
    }
}
