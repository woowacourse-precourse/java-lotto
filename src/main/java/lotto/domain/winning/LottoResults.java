package lotto.domain.winning;

import java.util.Map;

public class LottoResults {

    private final Map<LottoRanking, Integer> results;

    public LottoResults(Map<LottoRanking, Integer> results) {
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
                        .append(key.stringFormat()).append(" - ")
                        .append(value).append("개\n")
        );

        return stringBuilder.toString();
    }

    // 테스트용 메서드
    Map<LottoRanking, Integer> results() {
        return Map.copyOf(results);
    }
}
