package lotto.controller;

import java.util.List;
import lotto.domain.LottoMachine;
import lotto.domain.LottoJudge;
import lotto.domain.vo.BuyLottoList;
import lotto.domain.vo.Lotto;
import lotto.domain.vo.LottoWithBonus;
import lotto.domain.vo.Money;
import lotto.veiw.InputHandler;
import lotto.veiw.OutputHandler;

public class LottoController {

    InputHandler inputHandler = new InputHandler();
    OutputHandler outputHandler = new OutputHandler();

    public void run() {

        Money money = inputMoney();

        BuyLottoList buyLottoList = buyLotto(money);

        LottoWithBonus lottoWithBonus = inputBonus(inputLotto());

        LottoJudge lottoJudge = new LottoJudge(buyLottoList, lottoWithBonus);

        outputHandler.winningStatistics(lottoJudge);
        outputHandler.printYield(lottoJudge);
    }

    private BuyLottoList buyLotto(Money money) {
        try {
            LottoMachine lottoMachine = new LottoMachine(money);
            outputHandler.printBuyLottoList(lottoMachine);
            return new BuyLottoList(lottoMachine.getBuyLottoList());
        } catch (Exception e) {
            throw e;
        }
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
