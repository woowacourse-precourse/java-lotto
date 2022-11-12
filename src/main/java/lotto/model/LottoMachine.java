package lotto.model;

import lotto.Lotto;
import lotto.util.constants.LottoConstants;

public class LottoMachine {
    public int computeLottoTicketsCount(int purchaseAmount) {
        return purchaseAmount / LottoConstants.LOTTO_TICKET_PRICE;
    }

    public Lotto getLottoTicket() {
        LottoRandom lottoRandom = new LottoRandom();
        Lotto lotto = new Lotto(lottoRandom.pickNumbers());
        return lotto;
    }
}
