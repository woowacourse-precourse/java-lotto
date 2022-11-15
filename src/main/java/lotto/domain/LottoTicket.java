package lotto.domain;

import lotto.shell.Shell;

public class LottoTicket {

    private int LottoTicket;

    public LottoTicket() {
        LottoTicket = publishLottoTicket();
    }

    // 구매액만큼 로또를 발행하는 기능
    public int publishLottoTicket() {

        int lotteryTicket = new Shell().addAmount() % 1000;

        return lotteryTicket;
    }


}
