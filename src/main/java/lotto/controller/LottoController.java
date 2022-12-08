package lotto.controller;

import lotto.*;
import lotto.inputtool.WinningLottoChecker;
import lotto.inputview.InputBonusNumber;
import lotto.inputview.InputMoney;
import lotto.inputview.InputWinningLotto;
import lotto.lotto.Lotto;
import lotto.lotto.Lottos;
import lotto.lotto.WinningLotto;
import lotto.outputview.OutputLottos;
import lotto.outputview.Statistics;

import java.util.List;

public class LottoController {
    Lottos lottos = new Lottos();
    OutputLottos outputLottos = new OutputLottos();
    WinningLotto winningLotto;

    public void play() {
        buyLotto();
        printLottos();
        inputWinningLotto();
        printStatistics();
    }

    public void buyLotto() {
        InputMoney inputMoney = new InputMoney();
        String won = inputMoney.input();
        Money money = new Money(won);
        int amount = money.moneyToAmount();
        lottos.issuedLottos(amount);
    }

    public void printLottos() {
        List<Lotto> lottoList = lottos.getLottos();
        int amount = lottoList.size();
        outputLottos.printMsg(amount);
        for (int i = 0; i < amount; i++) {
            outputLottos.printLotto(lottoList.get(i).getNumbers());
        }
    }

    public void inputWinningLotto() {
        InputWinningLotto inputWinningLotto = new InputWinningLotto();
        InputBonusNumber inputBonusNumber = new InputBonusNumber();
        String lottoNumbers = inputWinningLotto.input();
        List lottoNumberList = WinningLottoChecker.checkAndConvertLotto(lottoNumbers);

        Lotto lotto = new Lotto(lottoNumberList);
        String input = inputBonusNumber.input();
        int bonusNumber = WinningLottoChecker.checkAndConvertBonus(input);
        winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    public void printStatistics() {
        Result result = new Result();
        result.compare(lottos, winningLotto);
        Statistics.printWin();
        int money = lottos.getLottos().size() * 1000;
        double rateOfRevenue = result.revenue(money);
        Statistics.printRevenue(rateOfRevenue);
    }
}
