package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningResult {

    public static final String WINNING_RESULT_MESSAGE = "%s - %d개\n";
    public static final String WINNING_RESULT_START_MESSAGE = "당첨금액\n---\n";

    private Map<Ranking, Integer> winningResult;

    public WinningResult(Lottos lottos, WinningNumbers winningNumbers) {
        this.winningResult = initialWinningResult();
        putWinningResult(lottos, winningNumbers);
    }

    private Map<Ranking, Integer> initialWinningResult() {
        return Arrays.stream(Ranking.values())
                .collect(Collectors.toMap(value -> value, count -> 0, (a, b) -> b, () -> new EnumMap<>(Ranking.class)));
    }

    public void putWinningResult(Lottos lottos, WinningNumbers winningNumbers) {
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
        return "";
    }

    @Override
    public String toString() {
        return makeRankingMessage();
    }
}
