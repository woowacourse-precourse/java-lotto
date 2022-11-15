package lotto.domain;

import java.util.*;

public class LottoProcess {
    static final String STATISTICS_START_STR = "당첨 통계";
    static final String STATISTICS_DIVISION_PARAGRAPH_STR = "---";
    static final String RATE_OF_RETURN_STR = "총 수익률은 %.1f%%입니다.";
    static final int START_COUNT = 0;
    static final int SIX_CORRECT = 6;
    static final int FIVE_CORRECT = 5;
    static final int FOUR_CORRECT = 4;
    static final int THREE_CORRECT = 3;
    static final int FIRST = 1;
    static final int SECOND = 2;
    static final int THIRD = 3;
    static final int FOURTH = 4;
    static final int FIFTH = 5;
    static final int REST = 6;
    static final int NOTHING = 0;
    static final float START_TOTAL_PRIZE = 0;
    static final int MAKE_PERCENTAGE = 100;

    private final List<List<Integer>> lottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final int money;

    public LottoProcess(List<List<Integer>> lottos, List<Integer> winningNumbers, int bonusNumber, int money) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.money = money;
    }

    public int compareWinningNumbers(List<Integer> lotto) {
        int countMatchingNumber = START_COUNT;

        for (int number : lotto) {
            if (this.winningNumbers.contains(number)) countMatchingNumber++;
        }

        return countMatchingNumber;
    }

    public List<Integer> decideRanks() {
        List<Integer> ranks = new ArrayList<>();

        for (List<Integer> lotto : this.lottos) {
            ranks.add(decideRank(compareWinningNumbers(lotto), lotto));
        }

        return ranks;
    }

    public int decideRank(int countMatchingNumber, List<Integer> lotto) {
        if (countMatchingNumber == SIX_CORRECT) return FIRST;
        if (countMatchingNumber == FIVE_CORRECT && lotto.contains(this.bonusNumber)) return SECOND;
        if (countMatchingNumber == FIVE_CORRECT) return THIRD;
        if (countMatchingNumber == FOUR_CORRECT) return FOURTH;
        if (countMatchingNumber == THREE_CORRECT) return FIFTH;
        return REST;
    }

    public Map<String, Integer> countRanks(List<Integer> ranks) {
        Map<String, Integer> ranking = new HashMap<>();
        ranking.put("FIRST", Collections.frequency(ranks, FIRST));
        ranking.put("SECOND", Collections.frequency(ranks, SECOND));
        ranking.put("THIRD", Collections.frequency(ranks, THIRD));
        ranking.put("FOURTH", Collections.frequency(ranks, FOURTH));
        ranking.put("FIFTH", Collections.frequency(ranks, FIFTH));

        return ranking;
    }

    public void printStatistics(Map<String, Integer> ranking) {
        // 실행 결과 예시와 맞추기 위해 한 칸 띄우기
        System.out.println();
        System.out.println(STATISTICS_START_STR);
        System.out.println(STATISTICS_DIVISION_PARAGRAPH_STR);
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getMessage(ranking.get(rank.name())));
        }
    }

    public void printCalculateRateOfReturn(Map<String, Integer> ranking) {
        float totalPrize = START_TOTAL_PRIZE;

        for (Rank rank : Rank.values()) {
            if (ranking.get(rank.name()) != NOTHING) {
                totalPrize += rank.getPrize();
            }
        }

        System.out.println(String.format(RATE_OF_RETURN_STR, (totalPrize / this.money) * MAKE_PERCENTAGE));
    }

}
