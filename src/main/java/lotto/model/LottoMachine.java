package lotto.model;

import lotto.util.constants.GameConstants;

public class LottoMachine {
    public int CountLottoTickets(int purchaseAmount) {
        return purchaseAmount / GameConstants.LOTTO_AMOUNT_UNIT;
    }
}
