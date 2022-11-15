package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class TicketMachine {

    public static List<List<Integer>> issueTickets(int ticketNumber) {
        List<List<Integer>> tickets = new ArrayList<>();
        while (tickets.size() < ticketNumber) {
            tickets.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return tickets;
    }
}
