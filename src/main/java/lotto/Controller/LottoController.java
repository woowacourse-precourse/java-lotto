package lotto.Controller;

import lotto.Model.Buyer;
import lotto.Model.Lotto;
import lotto.Model.LuckyLotto;
import lotto.Model.Result;
import lotto.View.Input;
import lotto.View.Output;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final Buyer buyer = new Buyer();
    private final Result result = new Result();
    private LuckyLotto luckyLotto;

    private void getLotto(){
        System.out.println("구입금액을 입력해 주세요.");
        int budget = Input.intInput();
        buyer.buyLotto(budget);
        Output.printPurchasedLottoAmount(buyer.getPurchasedAmount());
    }

    private void pickLottoNumbers(){
        buyer.pickLottoNumbers();
        Output.printLottoNumbers(buyer.getLottos());
    }

    private void createLuckyLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> luckyNumbers = Input.integerListInput();
        Lotto lotto = new Lotto(luckyNumbers);
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Input.intInput();
        luckyLotto = new LuckyLotto(luckyNumbers, bonusNumber);
    }

    private void getLottoResult(){
        result.computeLottoResult(buyer.getLottos(), luckyLotto);
        Output.printLottoResult(result.getResult());
    }

    private void profitStatistic(){
        result.computeProfitRate(buyer.getBudget());
        Output.printProfitRate(result.getProfitRate());
    }

    public void run(){
        getLotto();
        pickLottoNumbers();
        createLuckyLotto();
        getLottoResult();
        profitStatistic();
    }
}
