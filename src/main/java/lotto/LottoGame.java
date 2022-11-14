package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.util.InputChecker;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private Money money;
    private InputView inputView;
    private InputChecker inputChecker;
    private OutputView outputView;
    private List<Lotto> lottos;
    private Lotto winningLotto;

    public LottoGame(){
        inputView=new InputView();
        inputChecker=new InputChecker();
        outputView=new OutputView();
        lottos=new ArrayList<>();
    }
    public void startGame() throws IllegalArgumentException{
        getMoneyInput();
        getLottoNumberList();
        getLottoWinningNumberInput();
    }
    public void getMoneyInput() throws IllegalArgumentException{
        String input=inputView.inputMoney();
        if(inputChecker.checkInputMoney(input)){
            money=new Money(Integer.parseInt(input));
            System.out.printf("%d%s\n", money.getLottoCount(), outputView.printLottoPurchaseCount());
        }
    }
    public void getLottoNumberList() throws IllegalArgumentException {
        for(int i=0; i< money.getLottoCount(); i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            if (!lotto.getLotto().isEmpty()) {
                Collections.sort(lotto.getLotto());
                lottos.add(lotto);
            }
        }
        outputView.printLottoNumbersAll(lottos);
    }
    public void getLottoWinningNumberInput() throws IllegalArgumentException {
        String input=inputView.inputWinningNumber();
        List<String> inputWinningLottoNumbers = Arrays.asList(input.split(","));

        if(inputChecker.checkInputWinningLottoNumbersIsNumeric(inputWinningLottoNumbers)){
            List<Integer> changeStringToIntegerLottoNunbers=new ArrayList<>();
            for(String number : inputWinningLottoNumbers){
                changeStringToIntegerLottoNunbers.add(Integer.parseInt(number));
            }
            winningLotto=new Lotto(changeStringToIntegerLottoNunbers);
        }
    }
}
