package lotto.domain;

import lotto.utils.LottoNumberGenerator;

public class LottoMarket {

    public LottoTickets sellLottoTickets(Wallet wallet) {
        int lottoCount = wallet.calculate();

        return new LottoTickets(lottoCount, new LottoNumberGenerator());
    }
}
