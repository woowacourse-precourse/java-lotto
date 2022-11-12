package lotto.model;

import lotto.util.constants.LottoConstants;

public class LottoMachine {
    public int computeLottoTicketsCount(int purchaseAmount) {
        return purchaseAmount / LottoConstants.LOTTO_TICKET_PRICE;
    }
}
