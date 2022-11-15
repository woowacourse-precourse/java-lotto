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
            Rank rank = lotto.getRank(winningNumber);
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
     * 당첨 결과에 대한 통계를 출력하는 메소드
     */
    public void printStatistics(Amount amount) {
        System.out.println("\n당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            if (rank.equals(Rank.NO_LUCK)) {
                continue;
            }
            System.out.printf("%s - %d개\n", Rank.getMessage(rank), results.get(rank));
        }
        System.out.println("총 수익률은 " + amount.getYield(sumOfMoney()) + "%입니다.");
    }
}
