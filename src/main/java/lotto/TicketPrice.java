package lotto;

public enum TicketPrice {
    TICKET_PRICE(1_000);

    private int ticketPrice;
    TicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
