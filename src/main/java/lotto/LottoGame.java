package lotto;

public class LottoGame {

    private final Output output;
    private Lottos lottos;

    public LottoGame() {
        this.output = new Output();
    }

    public void run() {
        try {
            LottoMoney money = Input.inputMoney();
            buyLotto(money);
            createStatistics(money);
        } catch (IllegalArgumentException e) {
            Output.printExceptionMessage(e.getMessage());
        }
    }

    private void buyLotto(LottoMoney money) {
        lottos = LottoStore.byLottos(money);
        output.printPurchaseInfo(lottos);
    }

    private void createStatistics(LottoMoney money) {
        LottoResult lottoResult = new LottoResult(Input.inputWinningLotto(), Input.inputBonusNumber());
        WinningLotto winningLotto = lottoResult.lottoResult(lottos);
        output.printLottoResult(winningLotto.getGradesResult());
        output.printProfit(winningLotto.calculateYield(money));
    }
}
