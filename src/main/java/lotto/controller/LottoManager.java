package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinCount;
import lotto.util.LottoLogic;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private final LottoLogic logic = new LottoLogic();

    InputView in = new InputView();
    OutputView out = new OutputView();
    List<Integer> winNumbers = new ArrayList<>();
    int bonusNumber = 0;
    private final int lottoPrice = 1000;

    List<Lotto> boughtLottos = new ArrayList<>();
    int money = 0;

    public void run() {
        buyLotto();
        getWinNumberInput();
        winStatus();
    }

    private void buyLotto() {
        out.announceInputMoney();
        money = in.inputMoney();
        int lottoCount = logic.getAffordableLottoCount(money, lottoPrice);
        boughtLottos = logic.pickNumbers(lottoCount);
        out.printSpacer();
        out.announceBuyResult(lottoCount);
        out.printBoughtLotto(boughtLottos);
        out.printSpacer();
    }

    private void getWinNumberInput() {
        out.announceInputWinNumber();
        winNumbers = in.inputWinNumbers();
        out.printSpacer();
        out.announceInputBonusNumber();
        bonusNumber = in.inputBonusNumber(winNumbers);
    }

    private void winStatus() {
        List<LottoResult> lottoResults = logic.calculateWins(boughtLottos, winNumbers, bonusNumber);
        out.printSpacer();
        out.announceResult();
        out.printDivider();
        WinCount winCount = logic.getWinCount(lottoResults);
        out.printWinCount(winCount);
        String profitRatio = logic.calculateRatio(money, logic.getPrizeMoney(winCount));
        out.printProfitRatio(profitRatio);
    }

}
