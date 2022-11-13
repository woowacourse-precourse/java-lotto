package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.domain.InputChecker;

public class InputView {
    public static final String INPUT_PURCHASE_MONEY = "구매 금액을 입력해주세요.";

    InputChecker inputChecker;

    public InputView(){
        inputChecker=new InputChecker();
    }

    public void inputMoney() throws IllegalArgumentException{
        System.out.println(INPUT_PURCHASE_MONEY);
        inputChecker.checkInputMoney(Console.readLine());
    }
}
