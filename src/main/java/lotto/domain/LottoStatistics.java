package lotto.domain;

import java.util.*;

public class LottoStatistics {
    private final WinningNumber winningNumber;

    private Map<Rank, Integer> results;
    private long totalPrize;
    private float profitRate;

    public LottoStatistics(List<Lotto> lottoBundle, WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
        results = new HashMap<>();
        setResults(lottoBundle);
        setProfitRate(lottoBundle.size() * 1000);
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }

    private void setResults(List<Lotto> lottoBundle) {
        for (Lotto lotto : lottoBundle) {
            Rank rank = getRank(lotto);
            if (rank == null) {
                continue;
            }
            totalPrize += rank.getPrize();
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }

    }

    private Rank getRank(Lotto lotto) {
        Rank currentRank = null;
        for (Rank rank : Rank.values()) {
            if (rank.getMatchingCount() == getMatchingCount(lotto)) {
                currentRank = rank;
                break;
            }
        }
        return currentRank;
    }

    private int getMatchingCount(Lotto lotto) {
        long count = lotto.getNumbers().stream()
                .filter(e -> winningNumber.getNumbers().contains(e))
                .count();
        if (count == 5 && lotto.getNumbers().contains(winningNumber.getBonusNumber())) {
            count += 2;
        }
        return (int) count;
    }

    @Override
    public String toString() {
        String result = "---";
        for (Rank rank : sortByPrize(Rank.values())) {
            String matchingCount = rank.getResult();
            int prize = rank.getPrize();
            int count = results.getOrDefault(rank, 0);
            String currentResult = String.format("%s (%,d원) - %d개", matchingCount, prize, count);
            result += "\n" + currentResult;
        }
        result += "\n" + String.format("총 수익률은 %.1f%%입니다.", profitRate);
        return result;
    }

    private void setProfitRate(long purchasePrice) {
        profitRate = ((float)totalPrize / purchasePrice) * 100;
        profitRate = Math.round(profitRate * 10) / 10f;
    }

    private List<Rank> sortByPrize(Rank[] rank) {
        List<Rank> sorted = new ArrayList<>(List.of(rank));
        Collections.sort(sorted, Comparator.comparingInt(Rank::getPrize));
        return sorted;
    }
}
