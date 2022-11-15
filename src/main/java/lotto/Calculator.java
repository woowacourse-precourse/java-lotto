package lotto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    private final List<List<Integer>> purchasedLottos;
    private final List<Integer> winningNum;
    private final int bonusNum;


    public Calculator(List<List<Integer>> purchasedLottos, List<Integer> winningNum, int bonusNum) {
        this.purchasedLottos = List.copyOf(purchasedLottos);
        this.winningNum = List.copyOf(winningNum);
        this.bonusNum = bonusNum;
    }

    /**
     * Return the number of correct numbers which is bigger than 3
     * @return resultList
     */
    public List<Integer> calculateCorrectNum() {
        List<Integer> result = new ArrayList<>();
        for (List<Integer> lotto : purchasedLottos) {
            List<Integer> correctNumbers = winningNum.stream().filter(x -> lotto.contains(x))
                    .collect(Collectors.toList());
            if (correctNumbers.size() == 5 && isBonusCorrect(lotto)) {
                result.add(-1);
                continue;
            }
            if (correctNumbers.size() >= 3) {
                result.add(correctNumbers.size());
            }
        }
        return result;
    }

    /**
     * Check if bonus number is included in lotto number
     * @param lotto number list of single lotto ticket
     * @return whether bonus number is included
     */
    public boolean isBonusCorrect(List<Integer> lotto) {
        return lotto.contains(bonusNum);
    }

    /**
     * Return the count of ranks
     * @param resultList from {@link Calculator#calculateCorrectNum()}
     * @return linked hashmap containing the count of ranks
     */
    public LinkedHashMap<Result, Integer> countResultRank(List<Integer> resultList) {
        LinkedHashMap<Result, Integer> stats = new LinkedHashMap<>();
        List<Result> ranks = List.of(Result.values());
        for (Result rank : ranks) {
            List<Integer> rankCount = resultList.stream().filter(x -> x == rank.correctCount()).collect(Collectors.toList());
            int count = rankCount.size();
            stats.put(rank, count);
        }
        return stats;
    }

    /**
     * Calculate the total profit
     * @param stats result from {@link Calculator#countResultRank(List)}
     * @return profit
     */
    public double calcProfit(LinkedHashMap<Result, Integer> stats) {
        double profit = 0;
        for (Result key : stats.keySet()) {
            profit += key.prize() * stats.get(key);
        }
        double spent = Manager.COST * purchasedLottos.size();
        return (profit / spent) * 100;
    }

    /**
     * Print the statistic result of purchased lottos
     * @param stats result from {@link Calculator#countResultRank(List)}
     */
    public void showStats(LinkedHashMap<Result, Integer> stats) {
        System.out.println("\n당첨 통계\n---");
        for (Result key : stats.keySet()) {
            int correctCount = key.correctCount();
            if (correctCount == -1) {
                correctCount = 5;
            }
            String bonus = "";
            if (key.correctCount() == -1) {
                bonus = ", 보너스 볼 일치";
            }
            System.out.println(correctCount + "개 일치" + bonus + " (" + key.prizeString() + "원)" + " - " + stats.get(key) + "개");
        }
        System.out.println("총 수익률은 " + calcProfit(stats) + "%입니다.");
    }

    /**
     * Starts the process of calculating
     */
    public void calculate() {
        LinkedHashMap<Result, Integer> stats = countResultRank(calculateCorrectNum());
        showStats(stats);
    }
}
