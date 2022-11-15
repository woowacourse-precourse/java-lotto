package lotto.Controller;

import lotto.Dto.Lotto;
import lotto.Dto.Money;
import lotto.Services.CalculatedService;
import lotto.Services.LogicService;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.List;
import java.util.Map;

public class InputOutputController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CalculatedService calculatedService = new CalculatedService();
    private final LogicService logicService = new LogicService();
    private int lottoSize = 0;
    private List<Lotto> lottos;
    private Lotto winningNumbers;
    private int bonusNumber;
    private Map<String,Integer> lottoResult;

    public void inputMoney(){
        Money money = inputView.printLotoBuyMoney();
        lottoSize = calculatedService.lottoSize(money);
    }

    public void outputLottoSize(){
        outputView.printLottoSize(lottoSize);
        lottos = logicService.makeLotto(lottoSize);
        outputView.printLottoNumbers(lottos);
    }

    public void inputWinningNumbers(){
        winningNumbers = inputView.printWinningNumbers();
    }

    public void inputBonusNumber(){
        bonusNumber = inputView.printbonusNumber();
    }

    public void checkLottoNumbers(){
        lottoResult = logicService.checkLottoNumber(lottos,winningNumbers,bonusNumber);
        outputView.printWinnigResult(lottoResult);
    }

    public void calculatedYield(){
        String yield = calculatedService.calculatedYield(lottoResult);
        outputView.printYield(yield);
    }
}
