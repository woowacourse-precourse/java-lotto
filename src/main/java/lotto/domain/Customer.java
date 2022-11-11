package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.view.Constants.*;

public class Customer {
    private final int paidMoney;
    private final int numOfTicket;
    private final List<List<Integer>> tickets = new ArrayList<>();
    private final LinkedHashMap<Prize, Integer> winningTickets = new LinkedHashMap<>();

    public Customer(int paidMoney) {
        validateNoMoney(paidMoney);
        validateWrongMoney(paidMoney);
        this.paidMoney = paidMoney;
        this.numOfTicket = this.paidMoney / 1000;
        purchaseLottery();

        for (Prize prize: Prize.values()) {
            this.winningTickets.put(prize, 0);
        }
    }

    public int getNumOfTicket() {
        return this.numOfTicket;
    }

    public List<List<Integer>> getTickets() {
        return this.tickets;
    }

    public LinkedHashMap<Prize, Integer> getWinningTickets() {
        return winningTickets;
    }

    public void compareTickets(List<Integer> winningNumbers, int bonusNumber) {
        for (List<Integer> ticket: this.tickets) {
            compareNumbers(ticket, winningNumbers, bonusNumber);
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
        if (same < 3) {
            return;
        }
        if (same == 3 && !bonus) {
            int count = winningTickets.get(Prize.FIFTH);
            this.winningTickets.put(Prize.FIFTH, count + 1);
            return;
        }
        if (same == 4 && !bonus) {
            int count = winningTickets.get(Prize.FOURTH);
            this.winningTickets.put(Prize.FOURTH, count + 1);
            return;
        }
        if (same == 5 && !bonus) {
            int count = winningTickets.get(Prize.THIRD);
            this.winningTickets.put(Prize.THIRD, count + 1);
            return;
        }
        if (same == 5) {
            int count = winningTickets.get(Prize.SECOND);
            this.winningTickets.put(Prize.SECOND, count + 1);
            return;
        }
        int count = winningTickets.get(Prize.FIRST);
        this.winningTickets.put(Prize.FIRST, count + 1);
    }

    private void validateNoMoney(int paidMoney) {
        if (paidMoney == 0) {
            throw new IllegalArgumentException(BOUGHT_NOTHING);
        }
    }

    private void validateWrongMoney(int paidMoney) {
        if (paidMoney % 1000 != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_THOUSAND);
        }
    }

    private void purchaseLottery() {
        for (int i = 0; i < this.numOfTicket; i++) {
            List<Integer> ticket = pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, COUNT);
            Collections.sort(ticket);
            this.tickets.add(ticket);
        }
    }
}
