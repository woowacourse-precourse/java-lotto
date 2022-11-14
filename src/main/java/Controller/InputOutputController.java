package Controller;

import Dto.Money;
import Services.CalculatedService;
import View.InputView;
import View.OutputView;

public class InputOutputController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CalculatedService calculatedService = new CalculatedService();

    public void inputMoneyOutputLottoSize(){
        Money money = inputView.printLotoBuyMoney();
        int lottoSize = calculatedService.lottoSize(money);
        outputView.printLottoSize(lottoSize);
    }
}
