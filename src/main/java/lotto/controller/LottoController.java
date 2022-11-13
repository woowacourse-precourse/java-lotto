package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Compare;
import lotto.model.LottoMachine;
import lotto.model.Lotto;
import lotto.model.LottoReference;
import lotto.model.LottoWithBonus;
import lotto.model.Money;
import lotto.veiw.InputHandler;
import lotto.veiw.OutputHandler;

public class LottoController {

    InputHandler inputHandler = new InputHandler();
    OutputHandler outputHandler = new OutputHandler();

    public void run() {

        Money money = inputMoney();
        LottoMachine lottoMachine = new LottoMachine(money);
        LottoWithBonus lottoWithBonus = inputBonus(inputLotto());

        Compare compare = new Compare(lottoMachine, lottoWithBonus);

        Map<LottoReference, Integer> result = compare.getResult();
        float yield = compare.calculateYield(result);

        outputHandler.winningStatistics(result, yield);
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
