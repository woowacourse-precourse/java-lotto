package lotto.model;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.LottoConstant.LOTTO_PRICE;

public class LottoBuyer {
    List<Lotto> lottoTickets = new ArrayList<>();
    LottoResults lottoResults = new LottoResults();

    private final int totalLottoTickets;
    private final int payment;
    private long totalWinnings;

    public LottoBuyer(int payment) {
        this.payment = payment;
        this.totalLottoTickets = payment / LOTTO_PRICE;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public void addLottoTicket(Lotto lotto) {
        lottoTickets.add(lotto);
    }

    public int getTotalLottoTickets() {
        return totalLottoTickets;
    }

    public int getPayment() {
        return payment;
    }

    public void setTotalWinnings(long totalWinnings) {
        this.totalWinnings = totalWinnings;
    }

    public long getTotalWinnings() {
        return totalWinnings;
    }

    public LottoResults getLottoResults() {
        return lottoResults;
    }
}
