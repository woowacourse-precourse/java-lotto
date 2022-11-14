package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private static final int UNIT_PRICE = 1000;

    private int count;
    private List<Lotto> tickets;

    public Ticket(int count, List<Lotto> tickets) {
        this.count = count;
        this.tickets = tickets;
    }

    public Ticket(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public static Ticket purchase(int money) {
        List<Lotto> tickets = new ArrayList<>();
        int count = calculatePurchaseCount(money);

        for (int index = 0; index < count; index++) {
            tickets.add(Lotto.createLottoNumbers());
        }

        return new Ticket(count, tickets);
    }

    private static int calculatePurchaseCount(int money) {
        return money / UNIT_PRICE;
    }

    public String getPurchaseMessage() {
        StringBuilder message = new StringBuilder();

        for (Lotto ticket : tickets) {
            message.append(ticket.toString());
        }

        return message.toString();
    }

    public Lotto get(int index) {
        return tickets.get(index);
    }

    public int size() {
        return count;
    }
}
