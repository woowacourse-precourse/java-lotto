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
        this.winningResult = initialize();
        put(lottos, winningNumbers);
    }

    private Map<Ranking, Integer> initialize() {
        return Arrays.stream(Ranking.values())
                .collect(Collectors.toMap(value -> value, count -> 0, (a, b) -> b, () -> new EnumMap<>(Ranking.class)));
    }

    public void put(Lottos lottos, WinningNumbers winningNumbers) {
        List<Ranking> rankings = winningNumbers.calculateRanking(lottos);
        for (Ranking ranking : rankings) {
            winningResult.put(ranking, winningResult.get(ranking) + 1);
        }
    }

    private String makeMessage() {
        StringBuilder result = new StringBuilder();
        for (Ranking ranking : Ranking.values()) {
            makeMessageExceptNothing(result, ranking);
        }
        return WINNING_RESULT_START_MESSAGE + result;
    }

    public Double calculateTotalPrize() {
        return winningResult.keySet().stream()
                .mapToDouble(ranking -> (double) ranking.getPrize() * winningResult.get(ranking)).sum();
    }

    private void makeMessageExceptNothing(StringBuilder result, Ranking ranking) {
        if (ranking != Ranking.NOTHING) {
            result.append(String.format(WINNING_RESULT_MESSAGE, ranking.toString(), winningResult.get(ranking)));
        }
    }

    @Override
    public String toString() {
        return makeMessage();
    }
}
