package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.SystemMessage;
import lotto.domain.InputChecker;

public class InputView {

    InputChecker inputChecker;

    public InputView(){
        inputChecker=new InputChecker();
    }

    public void inputMoney() throws IllegalArgumentException{
        System.out.println(SystemMessage.INPUT_PURCHASE_MONEY.print());
        inputChecker.checkInputMoney(Console.readLine());
    }
}
