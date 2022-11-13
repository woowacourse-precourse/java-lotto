package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.SystemMessage;
import lotto.util.InputChecker;

public class InputView {

    InputChecker inputChecker;

    public InputView(){
        inputChecker=new InputChecker();
    }

    public String inputMoney() throws IllegalArgumentException{
        System.out.println(SystemMessage.INPUT_PURCHASE_MONEY.print());
        return Console.readLine();
    }
}
