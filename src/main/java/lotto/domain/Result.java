package lotto.domain;

import java.util.List;
import java.util.Map;

public class Result {
    private final Map<Rank, Integer> results;

    private Result(Map<Rank, Integer> results) {
        this.results = results;
    }

    /**
     * 로또들의 정보를 받아 당첨된 결과를 등수를 key, 개수를 value 로 가지는 Map 으로 저장하여 반환하는 메소드
     */
    public static Result of(List<Lotto> lottos, WinningNumber winningNumber) {
        Map<Rank, Integer> results = Rank.getRankWithCount();

        for (Lotto lotto : lottos) {
            int matchingCount = winningNumber.getMatchingCount(lotto);
            boolean hasBonusNumber = winningNumber.hasBonusNumber(lotto);
            Rank rank = Rank.of(matchingCount, hasBonusNumber);

            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }

        return new Result(results);
    }

    /**
     * 총 당첨금의 합을 계산하여 반환하는 메소드
     */
    private int sumOfMoney() {
        return results.keySet().stream()
                .mapToInt(rank -> rank.getMoney() * results.get(rank))
                .sum();
    }

    /**
     * 구입 금액과 총 당첨금의 합으로 수익률을 계산하여 반환하는 메소드
     */
    private double getYeild(int amount) {
        return Math.round(((sumOfMoney() / (double) amount) * 100) / 100.0);
    }
}
