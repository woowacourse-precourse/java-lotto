package lotto.domain.winning;

import java.util.Map;

public class LottoResults {

    private final Map<Ranking, Integer> results;

    public LottoResults(Map<Ranking, Integer> results) {
        this.results = results;
    }

    public int totalWinnings() {
        return results.entrySet().stream()
                .mapToInt(result -> result.getKey().sumOfWinnings(result.getValue()))
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        results.forEach(
                (key, value) -> stringBuilder
                        .append(key.toString()).append(" - ")
                        .append(value).append("개\n")
        );

        return stringBuilder.toString();
    }

    /**
     * 테스트용 메서드 입니다.
     */
    Map<Ranking, Integer> results() {
        return Map.copyOf(results);
    }
}
