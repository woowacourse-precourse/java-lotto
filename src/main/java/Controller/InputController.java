package Controller;

import Dto.Money;
import Services.CalculatedService;
import View.InputView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputController {

    private final InputView inputView = new InputView();
    private final CalculatedService calculatedService = new CalculatedService();

    public int inputMoney(){
        inputView.printLotoBuyMoney();
        String inputNumber = readLine();
        Money money = new Money(inputNumber);
        int lottoSize = calculatedService.lottoSize(money);
        return lottoSize;
    }
}
