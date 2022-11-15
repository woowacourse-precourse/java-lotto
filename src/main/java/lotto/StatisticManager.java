package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StatisticManager {

    private int winningMoney = 0;
    private final int[] winNumbers = {0, 0, 0, 0, 0, 0};
    private double yield;

    public void viewResult() {
        System.out.print("\n당첨 통계\n---\n");
        System.out.println("3개 일치 (5,000원) - " + winNumbers[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + winNumbers[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winNumbers[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winNumbers[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winNumbers[4] + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.", yield);
    }

    public void calculateYield(int playerMoney) {
        yield = winningMoney / (double) playerMoney * 100;
    }

    public void calculateFinalRank(int buyNumber, List<Integer> winningNumbers, int bonusNumber) {
        for (int i = 0; i < buyNumber; i++) {
            calculateRank(LottoMachine.lottoPaper.get(i), winningNumbers, bonusNumber);
        }
    }

    public void calculateRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int countOfMatch = compareWinningNumbers(lotto, winningNumbers);
        boolean matchBonus = compareBonusNumber(lotto, bonusNumber);
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);
        calculateWinTimes(rank);
        winningMoney += rank.getWinnings();
    }

    public List<Integer> stringListToIntegerList(List<String> numbers) {
        List<Integer> intNumbers = new ArrayList<>();
        for (String index : numbers) {
            intNumbers.add(Integer.parseInt(index));
        }
        return intNumbers;
    }

    public int stringToInt(String number) {
        return Integer.parseInt(number);
    }

    private void calculateWinTimes(Rank rank) {
        if (rank == Rank.FIFTH) {
            winNumbers[0]++;
        } else if (rank == Rank.FOURTH) {
            winNumbers[1]++;
        } else if (rank == Rank.THIRD) {
            winNumbers[2]++;
        } else if (rank == Rank.SECOND) {
            winNumbers[3]++;
        } else if (rank == Rank.FIRST) {
            winNumbers[4]++;
        }
    }

    private int compareWinningNumbers(Lotto lotto, List<Integer> winningNumbers) {
        return (int) IntStream.range(0, lotto.getNumbers().size())
                .filter(i -> lotto.getNumbers().contains(winningNumbers.get(i))).count();
    }

    private boolean compareBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }


}
