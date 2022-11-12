package lotto;

import lotto.domain.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {

    private static LottoMachine lottoMachine;
    private static InputView inputView;
    private static OutputView outputView;

    public Game(){
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        int money = inputView.inputMoney();
    }

}
