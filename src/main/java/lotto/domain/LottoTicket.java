package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoTicket;

    LottoTicket(List<Lotto> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public List<String> getLottoTicket() {
        List<String> issuedLottoTicket = new ArrayList<>();
        for (Lotto lotto : this.lottoTicket) {
            issuedLottoTicket
                    .add(lotto.getNumbers()
                            .stream()
                            .sorted()
                            .toString());
        }
        return issuedLottoTicket;
    }
}
