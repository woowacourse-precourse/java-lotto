package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.view.Constants.*;

public class Customer {
    private float earnedMoney = 0;
    private float earnedRate;
    private final int paidMoney;
    private int numOfTicket;
    private final List<List<Integer>> tickets = new ArrayList<>();
    private final LinkedHashMap<Prize, Integer> winningTickets = new LinkedHashMap<>();

    public Customer(int paidMoney) {
        validateNoMoney(paidMoney);
        validateWrongMoney(paidMoney);
        this.paidMoney = paidMoney;

        for (Prize prize: Prize.values()) {
            this.winningTickets.put(prize, 0);
        }
    }

    public int countTickets() {
        this.numOfTicket = this.paidMoney / 1000;
        return this.numOfTicket;
    }

    public List<List<Integer>> purchaseTickets() {
        for (int i = 0; i < this.numOfTicket; i++) {
            List<Integer> tempTicket = pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, COUNT);
            List<Integer> ticket = new ArrayList<>(tempTicket);
            Collections.sort(ticket);
            this.tickets.add(ticket);
        }
        return this.tickets;
    }

    public LinkedHashMap<Prize, Integer> countWinningTickets(
            List<Integer> winningNumbers,
            int bonusNumber
    ) {
        for (List<Integer> ticket: this.tickets) {
            compareNumbers(ticket, winningNumbers, bonusNumber);
        }
        return winningTickets;
    }

    public float calculateEarnedRate() {
        calculateEarnedMoney();
        this.earnedRate = (this.earnedMoney / this.paidMoney) * 100;
        return this.earnedRate;
    }

    private void calculateEarnedMoney() {
        List<Integer> prizeMoney = Prize.getMoneyValues();
        List<Integer> earnedCount = new ArrayList<>(this.winningTickets.values());

        for (int i = 0; i < prizeMoney.size(); i++) {
            this.earnedMoney += (prizeMoney.get(i) * earnedCount.get(i));
        }
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

    private void validateNoMoney(int paidMoney) {
        if (paidMoney == 0) {
            System.out.println(BOUGHT_NOTHING);
            throw new IllegalArgumentException();
        }
    }

    private void validateWrongMoney(int paidMoney) {
        if (paidMoney % 1000 != 0) {
            System.out.println(NOT_DIVISIBLE_BY_THOUSAND);
            throw new IllegalArgumentException();
        }
    }
}
