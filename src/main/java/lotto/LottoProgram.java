package lotto;

import java.util.List;

public class LottoProgram {
    private LottoStore lottoStore = new LottoStore();
    private User user = new User();

    public void makeUserLotto() {
        lottoStore.printInputMoney();
        int money = user.inputMoney();
        lottoStore.makePurchaseNumber(money);
        lottoStore.makeUserLotto();
        lottoStore.printUserLotto();
    }

    public void makeWinningLotto() {
        lottoStore.printInputWinningNumbers();
        List<Integer> winningNumber = user.inputWinningLottoNumbers();
        lottoStore.makeWinningLotto(winningNumber);
        lottoStore.printInputBonusNumber();
        int bonus = user.inputBonusNumber();
        lottoStore.makeBonusNumber(bonus);
    }

    public void makeProfitsStatistics() {
        lottoStore.printProfits();
    }
}
