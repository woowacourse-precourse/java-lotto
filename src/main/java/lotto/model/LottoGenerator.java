package lotto.model;

public class LottoGenerator {
    private final AutoLottoMachine autoLottoMachine;
    public LottoGenerator() {
        this.autoLottoMachine = new AutoLottoMachine();
    }

    public LottoTickets generateAutoLottoTickets(long count) {
        LottoTickets lottoTickets = new LottoTickets();
        for (int i = 0; i < count; i++) {
            lottoTickets.addLotto(autoLottoMachine.generateLottoTicket());
        }

        return lottoTickets;
    }

}
