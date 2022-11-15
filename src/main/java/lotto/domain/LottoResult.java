package lotto.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class LottoResult {
    private static final int INITIAL_NUMBER = 0;
    private static final int DECIMAL_POINT = 10;
    private static final int PERCENTAGE = 100;
    private final Map<Rank, Integer> lottoResult = new LinkedHashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, INITIAL_NUMBER);
        }
    }

    public void addRank(Rank rank) {
        lottoResult.put(rank, lottoResult.get(rank) + 1);
    }

    public double calculateProfit(Money money) {
        return (((double) (Math.round((earningPrice() / money.getMoney()) * DECIMAL_POINT * PERCENTAGE)))
                / DECIMAL_POINT);
    }

    private double earningPrice() {
        return lottoResult.entrySet()
                .stream()
                .map(this::calculatePrice)
                .reduce(0.0, Double::sum);
    }

    private double calculatePrice(Map.Entry<Rank, Integer> lottoResult) {
        return ((double)lottoResult.getKey().getWinningPrice() * lottoResult.getValue());
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

    public Map<Rank, Integer> getLottoResult() {
        return lottoResult;
    }
}
