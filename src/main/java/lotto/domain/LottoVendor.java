package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoVendor {//로또 판매처
    private final LottoIssueMachine lottoIssueMachine = new LottoIssueMachine();

    public List<Lotto> sale(int lottoTicketAmount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoTicketAmount; i++) {
            lottoTickets.add(lottoIssueMachine.autoGenerate());
        }
        return lottoTickets;
    }
}
