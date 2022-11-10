package lotto.domain.winning;

import java.util.Map;

public class LottoResults {

    private final Map<LottoRanking, Integer> results;

    public LottoResults(Map<LottoRanking, Integer> results) {
        this.results = results;
    }

    public String resultFormat() {
        StringBuilder stringBuilder = new StringBuilder();
        results.forEach(
                (key, value) -> stringBuilder
                        .append(key.stringFormat()).append(" - ")
                        .append(value).append("개\n"));
        return stringBuilder.toString();
    }

    public int totalWinnings() {
        return results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().sumOfWinnings(entry.getValue()))
                .sum();
    }

    // 테스트용 메서드
    Map<LottoRanking, Integer> results() {
        return Map.copyOf(results);
    }
}
