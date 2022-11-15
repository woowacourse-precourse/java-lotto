package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int LOTTO_NUMBER_LENGTH = 6;

    private List<List<Integer>> tickets;
    private final int ticketCount;

    public User (int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public List<List<Integer>> setTickets() {
        List<List<Integer>> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(Randoms.pickUniqueNumbersInRange(1,45, LOTTO_NUMBER_LENGTH));
        }
        this.tickets = tickets;
        return tickets;
    }

    public List<List<Integer>> getTickets() {
        return this.tickets;
    }
}