package lotto.Controller;

import lotto.Dto.Money;
import lotto.Services.CalculatedService;
import lotto.View.InputView;
import lotto.View.OutputView;

public class InputOutputController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CalculatedService calculatedService = new CalculatedService();
    private int lottoSize = 0;

    public void inputMoneyOutputLottoSize(){
        Money money = inputView.printLotoBuyMoney();
        lottoSize = calculatedService.lottoSize(money);
        outputView.printLottoSize(lottoSize);
    }


}
