package lotto;

import java.util.ArrayList;
import java.util.List;

//로또 판매처
public class LottoVendor {
    private final LottoMachine lottoMachine = new LottoMachine();

    public List<Lotto> sale(int lottoTicketAmount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoTicketAmount; i++) {
            lottoTickets.add(lottoMachine.autoGenerate());
        }
        return lottoTickets;
    }
}
