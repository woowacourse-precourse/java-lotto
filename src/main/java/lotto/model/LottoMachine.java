package lotto.model;

import lotto.util.constants.GameConstants;

public class LottoMachine {
    public int countLottoTickets(int purchaseAmount) {
        return purchaseAmount / GameConstants.LOTTO_TICKET_PRICE;
    }
}
