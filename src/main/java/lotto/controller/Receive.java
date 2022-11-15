package lotto.controller;

import lotto.console.InputBonusNumber;
import lotto.console.Output;
import lotto.console.InputMoney;
import lotto.console.InputWinningNumber;
import lotto.domain.AutoLottoSeller;
import lotto.domain.Lotto;
import lotto.service.NumberChart;

import java.util.List;

public class Receive {
    private final Output output = new Output();
    private final InputMoney inputMoney = new InputMoney();
    private final InputWinningNumber inputWinningNumber = new InputWinningNumber();
    private final InputBonusNumber inputBonusNumber = new InputBonusNumber();
    private final AutoLottoSeller autoLottoSeller = new AutoLottoSeller();


    public int receiveAndPrintMoney() {

        output.askPurchaseAmount();
        int money = inputMoney.getAndVerifyMoney();
        output.printEmptyLine();

        return money;
    }

    public List<Lotto> receiveAndPrintlottos(int money) {
        int number = money / NumberChart.LOTTO_MONEY.getValue();
        output.announceNumber(number);
        List<Lotto> lottos = autoLottoSeller.buyLotto(money);
        output.printLotto(lottos);
        output.printEmptyLine();

        return lottos;
    }

    public List<Integer> receiveAndPrintWinningNumbers() {
        output.askWinningNumber();
        List<Integer> winningNumber = inputWinningNumber.getAndVerifyNumber();
        output.printEmptyLine();

        return winningNumber;
    }

    public int receiveAndPrintBonusNumber(List<Integer> winnningNumber) {
        output.askBonusNumber();
        int bonusNumber = inputBonusNumber.getAndVerifyBonusNumber(winnningNumber);
        output.printEmptyLine();

        return bonusNumber;
    }
}
