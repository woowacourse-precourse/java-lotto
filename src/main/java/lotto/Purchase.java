package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Purchase {
    private final int PRICE_PER_TICKET = 1_000;
    public final int payment;
    public final int ticketAmount;
    public final List<List<Integer>> ticketList;

    public Purchase(int payment) {
        validate(payment);
        this.payment = payment;
        this.ticketAmount = getTicketAmount(this.payment);
        this.ticketList = getTicketList(this.ticketAmount);
    }

    private void validate(int payment) {
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private int getTicketAmount(int payment) {
        int ticketAmount = payment / this.PRICE_PER_TICKET;
        return ticketAmount;
    }

    private static List<List<Integer>> getTicketList(int ticketAmount){
        List<List<Integer>> ticketList = new ArrayList<List<Integer>>();
        for (int i = 0; i < ticketAmount; i++) {
            List<Integer> ticket = getTicket();
            ticketList.add(ticket);
        }
        return ticketList;
    }

    private static List<Integer> getTicket() {
        List<Integer> ticket = new ArrayList<Integer>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        ticket.sort(Comparator.naturalOrder());
        return ticket;
    }
    
}
