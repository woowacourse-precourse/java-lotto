package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Comparator {
    private float winningMoney = 0;
    private final int bonusNumber;
    private final List<Integer> winningNumbers;
    private final List<List<Integer>> lottoTickets;
    private final LinkedHashMap<Rank, Integer> winningTickets = new LinkedHashMap<>();

    public Comparator(
            List<List<Integer>> lottoTickets,
            List<Integer> winningNumbers,
            int bonusNumber
    ) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;

        for (Rank rank: Rank.values()) {
            this.winningTickets.put(rank, 0);
        }
    }

    public LinkedHashMap<Rank, Integer> countWinningTickets() {
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
                same += 1;
                continue;
            }
            if (winningNumbers.contains(number)) {
                same += 1;
            }
        }
        countSameNumber(same, bonus);
    }

    private void countSameNumber(int same, boolean bonus) {
        List<Rank> ranks = new ArrayList<>(List.of(Rank.values()));

        for (Rank rank: ranks) {
            if (same == rank.getCountOfMatch() && bonus == rank.getAcceptBonus()) {
                int count = winningTickets.get(rank);
                winningTickets.put(rank, count + 1);
            }
        }
    }

    public float calculateEarnedRate(int paidMoney) {
        calculateEarnedMoney();
        return (this.winningMoney / paidMoney) * 100;
    }

    private void calculateEarnedMoney() {
        List<Integer> prizeMoney = Rank.getWinningMoneyValues();
        List<Integer> earnedCount = new ArrayList<>(this.winningTickets.values());

        for (int i = 0; i < prizeMoney.size(); i++) {
            this.winningMoney += (prizeMoney.get(i) * earnedCount.get(i));
        }
    }
}
