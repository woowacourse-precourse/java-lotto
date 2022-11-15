package lotto;

public class LottoGameController {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void run() {
        LottoAmount amount = inputMoney();
        Lottos lottos = purchaseLotto(amount.makeLottoTickets());

    }

    private LottoAmount inputMoney() {
        SystemMessage.moneyInput();
        return new LottoAmount(Input.getNumber());
    }

    private Lottos purchaseLotto(int lottoTickets) {
        Lottos lottos = lottoGenerator.makeLottos(lottoTickets);
        SystemMessage.purchaseLotto(lottoTickets, lottos);
        return lottos;
    }
}
