package lotto;

import java.util.List;

public class LottoView {

    private static final String LOTTO_NUMBER_MESSAGE = "개를 구매했습니다.";

    public void printLottoInfo(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + LOTTO_NUMBER_MESSAGE);
        for (Lotto lottoTicket : lottoTickets) {
            lottoTicket.printNumbers();
        }
    }
}
