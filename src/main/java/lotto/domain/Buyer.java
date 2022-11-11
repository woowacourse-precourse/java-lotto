package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Buyer {
    private List<Lotto> holdingLottoTickets;

    public void purchase(LottoVendor lottoVendor, int purchaseMoney) {
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }
        int lottoTicketAmount=purchaseMoney/1000;
        holdingLottoTickets=lottoVendor.sale(lottoTicketAmount);
    }
    public List<Lotto> getHoldingLottoTickets() {
        return Collections.unmodifiableList(holdingLottoTickets);
    }
    public int countHoldingLotto(){
        return holdingLottoTickets.size();
    }
}