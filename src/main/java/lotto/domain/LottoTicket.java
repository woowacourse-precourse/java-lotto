package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoTicket;

    public LottoTicket(List<Lotto> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public List<Lotto> getLottoTicket() {
        return this.lottoTicket;
    }

    public List<String> convertString() {
        List<String> issuedLottoTicket = new ArrayList<>();
        for (Lotto lotto : this.lottoTicket) {
            issuedLottoTicket.add(lotto.sortNumbers().toString());
        }
        return issuedLottoTicket;
    }
}
