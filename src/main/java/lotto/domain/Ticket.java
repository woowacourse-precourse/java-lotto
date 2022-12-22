package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.view.Constants.*;

public class Ticket {
    private final int numOfTicket;
    private final List<List<Integer>> lottoTickets = new ArrayList<>();

    public Ticket(int paidMoney) {
        this.numOfTicket = paidMoney / 1000;
    }

    public int getNumOfTicket() {
        return numOfTicket;
    }

    public List<List<Integer>> purchaseTickets() {
        for (int i = 0; i < this.numOfTicket; i++) {
            List<Integer> tempTicket = pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, COUNT);
            List<Integer> ticket = new ArrayList<>(tempTicket);
            Collections.sort(ticket);
            this.lottoTickets.add(ticket);
        }
        return this.lottoTickets;
    }
}
