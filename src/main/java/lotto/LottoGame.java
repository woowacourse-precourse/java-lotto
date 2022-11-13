package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.util.InputChecker;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

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
        getLottoNumberList();
    }
    public void getMoneyInput(){
        String input=inputView.inputMoney();
        if(inputChecker.checkInputMoney(input)){
            money=new Money(Integer.parseInt(input));
            System.out.printf("%d%s\n", money.getLottoCount(), outputView.printLottoPurchaseCount());
        }
    }
    public void getLottoNumberList(){
        Lotto lotto=new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
