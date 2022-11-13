package Controller;

import Dto.Money;
import View.InputView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputController {

    private InputView inputView = new InputView();

    public void inputMoney(){
        inputView.printLotoBuyMoney();
        String inputNumber = readLine();
        Money money = new Money(inputNumber);
    }
}
