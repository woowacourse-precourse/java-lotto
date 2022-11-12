package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Comparator {
    private float winningMoney = 0;
    private float earnedRate;
    private final List<List<Integer>> lottoTickets;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final LinkedHashMap<Prize, Integer> winningTickets = new LinkedHashMap<>();


    public Comparator(
            List<List<Integer>> lottoTickets,
            List<Integer> winningNumbers,
            int bonusNumber
    ) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LinkedHashMap<Prize, Integer> countWinningTickets() {
        for (List<Integer> ticket: this.lottoTickets) {
            compareNumbers(ticket, this.winningNumbers, this.bonusNumber);
        }
        return winningTickets;
    }

    private void compareNumbers(List<Integer> ticket, List<Integer> winningNumbers, int bonusNumber) {
        int same = 0;
        boolean bonus = false;

        for (int number: ticket) {
            if (number == bonusNumber) {
                bonus = true;
                continue;
            }
            if (winningNumbers.contains(number)) {
                same += 1;
            }
        }
        countSameNumber(same, bonus);
    }

    private void countSameNumber(int same, boolean bonus) {
        List<Prize> ranks = new ArrayList<>(List.of(Prize.values()));
        List<Integer> sameCount = new ArrayList<>(Prize.getSameValues());
        List<Boolean> acceptBonus = new ArrayList<>(Prize.getBonusValues());

        for (int i = 0; i < ranks.size(); i++) {
            if (same == sameCount.get(i) && bonus == acceptBonus.get(i)) {
                Prize rank = ranks.get(i);
                int count = winningTickets.get(rank);
                winningTickets.put(rank, count + 1);
            }
        }
    }

    public float calculateEarnedRate(int paidMoney) {
        calculateEarnedMoney();
        this.earnedRate = (this.winningMoney / paidMoney) * 100;
        return this.earnedRate;
    }

    private void calculateEarnedMoney() {
        List<Integer> prizeMoney = Prize.getMoneyValues();
        List<Integer> earnedCount = new ArrayList<>(this.winningTickets.values());

        for (int i = 0; i < prizeMoney.size(); i++) {
            this.winningMoney += (prizeMoney.get(i) * earnedCount.get(i));
        }
    }
}
