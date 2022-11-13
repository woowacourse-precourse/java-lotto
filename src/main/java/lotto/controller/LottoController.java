package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Compare;
import lotto.domain.LottoMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoReference;
import lotto.domain.LottoWithBonus;
import lotto.domain.Money;
import lotto.veiw.InputHandler;
import lotto.veiw.OutputHandler;

public class LottoController {

    InputHandler inputHandler = new InputHandler();
    OutputHandler outputHandler = new OutputHandler();

    public void run() {

        Money money = inputMoney();
        LottoMachine haveLotto = new LottoMachine(money);
        LottoWithBonus winningLotto = inputBonus(inputLotto());

        Compare compare = new Compare(haveLotto, winningLotto);

        Map<LottoReference, Integer> result = compare.getResult();

        outputHandler.winningStatistics(result);
        outputHandler.printYield(compare.getYield(result));
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
