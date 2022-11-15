package lotto;

public class Output {
    private final TicketHandler ticketHandler;

    public Output() {
        ticketHandler = new TicketHandler();
    }

    public void printTickets() {
        for (Lotto l : Application.getLotto()) {
            System.out.println(l.getNumbers());
        }
    }
}
