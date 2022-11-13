package lotto;

import lotto.domain.Money;
import lotto.util.InputChecker;
import lotto.view.InputView;

public class LottoGame {
    private Money money;
    private InputView inputView;
    private InputChecker inputChecker;

    public LottoGame(){
        inputView=new InputView();
        inputChecker=new InputChecker();
    }
    public void startGame(){
        getMoneyInput();
    }
    public void getMoneyInput(){
        String input=inputView.inputMoney();
        if(inputChecker.checkInputMoney(input)){
            System.out.println("입력 통과");
        }
    }
}
