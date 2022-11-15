package lotto;

public enum TicketPrice {
    TICKET_PRICE(1_000);

    private final int ticketPrice;
    TicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }
}
