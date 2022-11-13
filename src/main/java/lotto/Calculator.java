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
        List<Integer> resultList = new ArrayList<>();
        for (List<Integer> lotto : purchasedLottos) {
            List<Integer> correctNumbers = winningNum.stream().filter(x -> lotto.contains(x))
                    .collect(Collectors.toList());
            if (correctNumbers.size() == 5 && isBonusCorrect(lotto)) {
                resultList.add(-1);
                continue;
            }
            if (correctNumbers.size() >= 3) {
                resultList.add(correctNumbers.size());
            }
        }
        return resultList;
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
        List<Result> resultEnums = List.of(Result.values());
        for (Result resultEnum : resultEnums) {
            List<Integer> rankCount = resultList.stream().filter(x -> x == resultEnum.correctCount()).collect(Collectors.toList());
            int count = rankCount.size();
            stats.put(resultEnum, count);
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
        for (Result keyEnum : stats.keySet()) {
            profit += keyEnum.prize() * stats.get(keyEnum);
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
        for (Result keyEnum : stats.keySet()) {
            int correctCount = keyEnum.correctCount();
            if (correctCount == -1) {
                correctCount = 5;
            }
            String bonus = "";
            if (keyEnum.correctCount() == -1) {
                bonus = ", 보너스 볼 일치";
            }
            System.out.println(correctCount + "개 일치" + bonus + " (" + keyEnum.prizeString() + "원)" + " - " + stats.get(keyEnum) + "개");
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
