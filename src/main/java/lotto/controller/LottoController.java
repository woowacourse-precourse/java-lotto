package lotto.controller;

import java.util.List;
import lotto.domain.LottoJudge;
import lotto.domain.LottoMachine;
import lotto.domain.vo.BuyLotteries;
import lotto.domain.vo.Lotto;
import lotto.domain.vo.LottoResult;
import lotto.domain.vo.LottoWithBonus;
import lotto.domain.vo.Money;
import lotto.veiw.InputHandler;
import lotto.veiw.OutputHandler;

public class LottoController {

    InputHandler inputHandler = new InputHandler();
    OutputHandler outputHandler = new OutputHandler();


    public void run() {

        Money money = inputMoney();

        BuyLotteries buyLotteries = buyLotto(money);

        LottoWithBonus lottoWithBonus = inputBonus(inputLotto());

        LottoResult lottoResult = getResult(buyLotteries, lottoWithBonus);

        outputResult(lottoResult);
    }


    private BuyLotteries buyLotto(Money money) {
        try {
            LottoMachine lottoMachine = new LottoMachine(money);
            outputHandler.printBuyLottoList(lottoMachine);
            return new BuyLotteries(lottoMachine.getBuyLotteries());
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

    private LottoResult getResult(BuyLotteries buyLotteries, LottoWithBonus lottoWithBonus) {
        LottoJudge lottoJudge = new LottoJudge(buyLotteries, lottoWithBonus);
        return lottoJudge.calculateResult();
    }

    private void outputResult(LottoResult lottoResult) {
        outputHandler.winningStatistics(lottoResult);
        outputHandler.printYield(lottoResult);
    }
}
