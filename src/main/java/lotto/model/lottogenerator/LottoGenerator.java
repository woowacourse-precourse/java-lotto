package lotto.model.lottogenerator;

import lotto.model.lottoticket.LottoTickets;

public class LottoGenerator {

    private final LottoMachine autoLottoMachine;

    public LottoGenerator() {
        this.autoLottoMachine = new AutoLottoMachine();
    }

    public LottoTickets generateAutoLottoTicketsAs(long count) {
        LottoTickets lottoTickets = new LottoTickets();

        for (int i = 0; i < count; i++) {
            lottoTickets.addLotto(autoLottoMachine.generateLottoTicket());
        }

        return lottoTickets;
    }

}
