package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoMaker;

import java.util.List;

public class OutputView {

    public void printLottoTicktesCount(int ticketCount){
        System.out.printf("%d개를 구매했습니다.\n", ticketCount);
    }

    public void printLottoTikects(List<Lotto> lottoTickets){
        for(Lotto lotto : lottoTickets){
            System.out.println(lotto.getSortedNumbers());
        }
    }

}
