package lotto;

public class LottoController {
    public void start() {
        Money userInputMoney = new Money();
        userInputMoney.init();
        LottoGame lottoGame = new LottoGame();
        lottoGame.buy(userInputMoney);
    }
}
