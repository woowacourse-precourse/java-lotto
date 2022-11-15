package lotto.model.machine;

import lotto.io.Output;

public class LottoTicket {

    private final Lotto lottoTicket;

    public LottoTicket() {
        this.lottoTicket = RandomNumberGenerator.createNumbers();
    }

    public void showTicketNumbers(Output output) {
        output.print(lottoTicket.toString());
    }

    public Lotto getLotto() {
        return lottoTicket;
    }
}
