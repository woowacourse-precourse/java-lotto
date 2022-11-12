package lotto.model;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.LottoConstant.LOTTO_PRICE;

public class LottoBuyer {
    List<Lotto> lottoTickets = new ArrayList<>();
    private final int totalLottoTickets;
    private final int payment;

    public LottoBuyer(int inputAmount) {
        this.payment = inputAmount;
        this.totalLottoTickets = inputAmount / LOTTO_PRICE;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public int getTotalLottoTickets() {
        return totalLottoTickets;
    }

    public int getPayment() {
        return payment;
    }

    public void addLottoTicket(Lotto lotto) {
        lottoTickets.add(lotto);
    }
}
