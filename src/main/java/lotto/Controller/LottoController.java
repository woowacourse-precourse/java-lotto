package lotto.Controller;

import lotto.Domain.BonusNumber;
import lotto.Domain.LottoCompare;
import lotto.Domain.LottoGenerator;
import lotto.Domain.LottoWinnerNumber;
import lotto.Lotto;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.List;

public class LottoController {
    List<List<Integer>> purchaseUserLotto;
    List<Integer> winnerLotto;
    String userMoney;

    public void startLottoGame() {
        userMoney = InputView.inputMoney();
        purchaseLotto(userMoney);
    }

    public void purchaseLotto(String userMoney) {
        LottoGenerator lottoGenerator = new LottoGenerator(userMoney);
        purchaseUserLotto = lottoGenerator.issueLotto();
        OutputView.printUserLotto(purchaseUserLotto);
        inputWinnerLotto();
    }

    public void inputWinnerLotto() {
        String winnerLottoNumber = InputView.inputWinnerLotto();

        Lotto lotto = new Lotto(winnerLottoNumber);
        winnerLotto = lotto.convertWinnerNumber(winnerLottoNumber);
        new Lotto(winnerLotto);
        inputBonusLotto();
    }

    public void inputBonusLotto() {
        String bonus = InputView.inputBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(bonus);
        bonusNumber.duplicateInputBonusNumber(winnerLotto);
        compareWinnerNumber(bonus);
    }

    public void compareWinnerNumber(String bonusNumber) {
        LottoCompare lottoCompare = new LottoCompare();
        List<List<Integer>> compareResultLotto = lottoCompare.compareResultLotto(purchaseUserLotto, winnerLotto, bonusNumber);
        lottoCompare.resultLottoCount(compareResultLotto);
        getLottoWinningMessage();
    }

    public void getLottoWinningMessage() {
        OutputView.printUserResultLottoMessage();
        getUserProfit();
    }

    public void getUserProfit() {
        double userProfit = LottoCompare.resultProfit(Integer.parseInt(userMoney));
        OutputView.printUserProfit(userProfit);
    }
}
