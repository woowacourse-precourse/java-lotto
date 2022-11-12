package lotto.model;


import java.util.List;

public class User {
    private int purchaseAmount;
    private int lottoTicketCount;
    private List<Lotto> lottoTickets;

    public User(int purchaseAmount, int lottoTicketCount, List<Lotto> lottoTickets) {
        this.purchaseAmount = purchaseAmount;
        this.lottoTicketCount = lottoTicketCount;
        this.lottoTickets = lottoTickets;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

}
