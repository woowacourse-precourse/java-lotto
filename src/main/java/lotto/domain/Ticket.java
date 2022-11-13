package lotto.domain;

public class Ticket {
    private static final int UNIT = 1000;
    private final Integer tickets;

    public Ticket(Money money) {
        this.tickets = money.getMoney() / UNIT;
    }

    public Integer getTickets() {
        return this.tickets;
    }
}
