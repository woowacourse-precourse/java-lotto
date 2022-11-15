package lotto.controller;


import lotto.shell.Amount;

public class LottoTicket {

    private int LottoTicket;

    public LottoTicket() {
        LottoTicket = publishLottoTicket();
    }

    // 구매액만큼 로또를 발행하는 기능
    public int publishLottoTicket() {

        int lotteryTicket = new Amount().buildAmount() % 1000;

        return lotteryTicket;
    }

}
