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
    private long sumOfMoney() {
        return results.keySet().stream()
                .mapToLong(rank -> (long) rank.getMoney() * results.get(rank))
                .sum();
    }

    /**
     * 구입 금액을 파라미터로 받아 총 당첨금의 합으로 수익률(소수점 둘째 자리에서 반올림)을 계산하여 반환하는 메소드
     */
    private String getYield(int amount) {
        return String.format("%.1f", sumOfMoney() / (double) amount * 100);
    }

    /**
     * 당첨 결과에 대한 통계를 출력하는 메소드
     */
    public void printStatistics(int amount) {
        System.out.println("\n당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            if (rank.equals(Rank.NO_LUCK)) {
                continue;
            }
            System.out.printf("%s - %d개\n", Rank.getMessage(rank), results.get(rank));
        }
        System.out.println("총 수익률은 " + getYield(amount) + "%입니다.");
    }
}
