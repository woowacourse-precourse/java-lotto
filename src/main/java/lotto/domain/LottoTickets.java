package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<LottoNumbers> LottoTicket = new ArrayList<>();

    public LottoTickets(int lottoCount) {
        createLottoTickets(lottoCount);
    }

    private void createLottoTickets(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            LottoTicket.add(new LottoNumbers());
        }
    }
}


