package lotto;

public class Purchase {
    private final int payment;
    private final int pricePerTicket = 1_000;
    public int ticketAmount;

    public Purchase(int payment) {
        validate(payment);
        this.payment = payment;
        this.ticketAmount = getTicketAmount(this.payment);
    }

    private void validate(int payment) {
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private int getTicketAmount(int payment){
        ticketAmount = payment / this.pricePerTicket;
        return ticketAmount;
    }
}
