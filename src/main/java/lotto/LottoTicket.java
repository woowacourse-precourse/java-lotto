package lotto;

import java.util.List;

public class LottoTicket {
    private List<Lotto> lottoTickets;

    public void buyTicket(LottoSeller lottoSeller , int ticketMoney){
        if(ticketMoney % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }
        int ticketAmount = ticketMoney / 1000;
        System.out.println(ticketAmount + "개를 구매했습니다.");

        lottoTickets = lottoSeller.inputLottoNumber(ticketAmount);
    }
}
