package lotto.Controller;

import lotto.Dto.Lotto;
import lotto.Dto.Money;
import lotto.Services.CalculatedService;
import lotto.Services.LogicService;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.List;

public class InputOutputController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CalculatedService calculatedService = new CalculatedService();
    private final LogicService logicService = new LogicService();
    private int lottoSize = 0;
    private List<Lotto> lottos;
    private Lotto winningNumbers;
    private int bonusNumber;

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
}
