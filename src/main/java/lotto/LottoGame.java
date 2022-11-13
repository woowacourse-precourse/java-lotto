package lotto;

import lotto.domain.Money;
import lotto.util.InputChecker;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private Money money;
    private InputView inputView;
    private InputChecker inputChecker;
    private OutputView outputView;

    public LottoGame(){
        inputView=new InputView();
        inputChecker=new InputChecker();
        outputView=new OutputView();
    }
    public void startGame(){
        getMoneyInput();
    }
    public void getMoneyInput(){
        String input=inputView.inputMoney();
        if(inputChecker.checkInputMoney(input)){
            money=new Money(Integer.parseInt(input));
            System.out.printf("%d%s\n", money.getLottoCount(), outputView.printLottoPurchaseCount());
        }
    }
}
