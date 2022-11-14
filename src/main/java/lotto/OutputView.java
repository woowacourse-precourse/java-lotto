package lotto;

import java.util.List;

public class OutputView {

    public void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for(Lotto lotto : lottoTickets) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

}
