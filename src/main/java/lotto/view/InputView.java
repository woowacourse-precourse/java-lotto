package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.domain.SystemMessage;
import lotto.util.InputChecker;

public class InputView {

    InputChecker inputChecker;

    public InputView(){
        inputChecker=new InputChecker();
    }

    public String inputMoney() {
        System.out.println(SystemMessage.INPUT_PURCHASE_MONEY.print());
        return Console.readLine();
    }
    public String inputWinningNumber() throws IllegalArgumentException{
        System.out.println(SystemMessage.INPUT_WINNING_LOTTO_NUMBER.print());
        return Console.readLine();
    }
    public String inputBonusNumber() throws IllegalArgumentException{
        System.out.println(SystemMessage.INPUT_BONUS_NUMBER.print());
        return Console.readLine();
    }
}
