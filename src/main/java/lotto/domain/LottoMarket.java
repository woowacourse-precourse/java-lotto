package lotto.domain;

import lotto.domain.lotto.LottoTickets;
import lotto.utils.LottoNumberGenerator;

public class LottoMarket {

    public LottoTickets buy(Wallet wallet) {
        int lottoCount = wallet.calculate();

        return new LottoTickets(lottoCount, new LottoNumberGenerator());
    }
}
