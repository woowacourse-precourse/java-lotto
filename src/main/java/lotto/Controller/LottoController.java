package lotto.Controller;

import lotto.Model.Buyer;
import lotto.Model.Lotto;
import lotto.Model.LuckyLotto;
import lotto.Model.Result;
import lotto.View.Input;
import lotto.View.Output;

import java.util.List;

public class LottoController {

    public final Buyer buyer = new Buyer();
    public final Result result = new Result();
    public LuckyLotto luckyLotto;

    public void getLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        int budget = Input.intInput();
        buyer.buyLotto(budget);
        Output.printPurchasedLottoAmount(buyer.getPurchasedAmount());
    }

    public void pickLottoNumbers() {
        buyer.pickLottoNumbers();
        Output.printLottoNumbers(buyer.getLottos());
    }

    public Lotto pickLuckyNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> luckyNumbers = Input.integerListInput();
        Lotto luckyLotto = new Lotto(luckyNumbers);
        return luckyLotto;
    }

    public int pickBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Input.intInput();
        return bonusNumber;
    }

    public void createLuckyLotto() {
        List<Integer> luckyNumbers = pickLuckyNumber().getLottoNumbers();
        int bonusNumber = pickBonusNumber();
        luckyLotto = new LuckyLotto(luckyNumbers, bonusNumber);
    }

    public void getLottoResult() {
        result.computeLottoResult(buyer.getLottos(), luckyLotto);
        Output.printLottoResult(result.getResult());
    }

    public void profitStatistic() {
        result.computeProfitRate(buyer.getBudget());
        Output.printProfitRate(result.getProfitRate());
    }

    public void run() {
        getLotto();
        pickLottoNumbers();
        createLuckyLotto();
        getLottoResult();
        profitStatistic();
    }
}
