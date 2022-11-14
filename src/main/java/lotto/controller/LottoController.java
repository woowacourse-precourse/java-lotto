package lotto.controller;

import java.util.List;
import lotto.domain.BuyLottoList;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.LottoWithBonus;
import lotto.domain.Money;
import lotto.veiw.InputHandler;
import lotto.veiw.OutputHandler;

public class LottoController {

    InputHandler inputHandler = new InputHandler();
    OutputHandler outputHandler = new OutputHandler();

    public void run() {

        Money money = inputMoney();
        LottoMachine lottoMachine = new LottoMachine(money);

        BuyLottoList buyLottoList = new BuyLottoList(lottoMachine.getBuyLottoList());
        LottoWithBonus lottoWithBonus = inputBonus(inputLotto());

        LottoResult lottoResult = new LottoResult(buyLottoList, lottoWithBonus);

        outputHandler.winningStatistics(lottoResult);
        outputHandler.printYield(lottoResult);
    }

    private Money inputMoney() {
        int inputMoney = inputHandler.inputMoney();
        try {
            return new Money(inputMoney);
        } catch (Exception e) {
            throw e;
        }
    }

    private Lotto inputLotto() {
        List<Integer> inputList = inputHandler.inputLotto();
        try {
            return new Lotto(inputList);
        } catch (Exception e) {
            throw e;
        }
    }

    private LottoWithBonus inputBonus(Lotto lotto) {
        int bonusNumber = inputHandler.inputBonus();
        try {
            return new LottoWithBonus(lotto, bonusNumber);
        } catch (Exception e) {
            throw e;
        }
    }
}
