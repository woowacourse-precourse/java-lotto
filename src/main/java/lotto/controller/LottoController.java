package lotto.controller;

import lotto.domain.*;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

import java.util.List;

public class LottoController {
    private ConsoleInput consoleInput = new ConsoleInput();
    private ConsoleOutput consoleOutput = new ConsoleOutput();
    InputProcessing inputProcessing = new InputProcessing();
    public void play(){
        MoneyToAmount moneyToAmount = new MoneyToAmount(consoleInput.inputMoneyMsg());
        IssuedLotto issuedLotto = new IssuedLotto(moneyToAmount.getAmount());
        consoleOutput.printLottoList(moneyToAmount.getAmount(), issuedLotto.getLottoList());
        List<Integer> inputNumber = inputProcessing.inputConverter(consoleInput.inputWinningLotto());
        Lotto winningNumber = new Lotto(inputNumber);
        BonusNumber bonusNumber = new BonusNumber(consoleInput.inputBonusNumber());
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);
        LottoResult lottoResult = new LottoResult(issuedLotto.getLottoList().lottoResult(winningLotto));
        consoleOutput.printStatistics(lottoResult.toString());
        consoleOutput.printProfitRatio(moneyToAmount.profitRatio(lottoResult.totalPrize()));
    }
}
