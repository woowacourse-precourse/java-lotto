package lotto;

import lotto.domain.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {

    private static final int LOTTO_UNIT = 1000;
    private static LottoMachine lottoMachine;
    private static InputView inputView;
    private static OutputView outputView;

    public Game(){
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        int money = inputView.inputMoney();
        int lottoCount = money/LOTTO_UNIT;
        outputView.printLottoCount(lottoCount);
    }

}
