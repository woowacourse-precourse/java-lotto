package lotto.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class LottoResult {
    private static final int INITIAL_NUMBER = 0;
    private static final int DECIMAL_POINT = 100;
    private final Map<Rank, Integer> lottoResult = new LinkedHashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, INITIAL_NUMBER);
        }
    }

    public void addRank(Rank rank) {
        lottoResult.put(rank, lottoResult.get(rank) + 1);
    }

    @Override
    public String toString() {
        return lottoResult
                .entrySet()
                .stream()
                .map(this::createMatchMessage)
                .collect(joining("\n"));
    }

    private String createMatchMessage(Map.Entry<Rank, Integer> lottoResult) {
        return (lottoResult.getKey().getMatchMessage())
                .replaceAll("\\$\\{number}", Integer.toString(lottoResult.getValue()));
    }
}
