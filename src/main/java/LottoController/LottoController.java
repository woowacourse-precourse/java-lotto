package LottoController;

import domain.LottoGame;
import domain.Player;
import lotto.Lotto;
import util.GameStatus;
import util.OutputPharse;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    private final LottoGame lottoGame;

    public LottoController(InputView inputView, OutputView outputView, LottoGame lottoGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGame = lottoGame;
    }

    public void start() {
        buy();

        setWinningLotto();
        setBonnusNumber();

        checkLotto();
        printResult();
    }

    public void buy() {
        outputView.printMsg(OutputPharse.INPUT_AMOUNT.getMsg());
        lottoGame.buy(inputView.getUserAmount());
        outputView.printEmptyLine();
        outputView.printLottoList(lottoGame.getPlayer().getLottoList());
        outputView.printEmptyLine();
    }

    public void setWinningLotto() {
        outputView.printMsg(OutputPharse.INPUT_WINNING_LOTTO.getMsg());
        lottoGame.setWiningLotto(inputView.getWinningLotto());
        outputView.printEmptyLine();
    }

    public void setBonnusNumber() {
        outputView.printMsg(OutputPharse.INPUT_BONNUS_LOTTO.getMsg());
        lottoGame.setBonnusNumber(inputView.getBonnusNumber());
        outputView.printEmptyLine();
    }

    public void checkLotto() {
        lottoGame.checkLotto();
    }

    public void printResult() {
        outputView.printMsg(OutputPharse.RESULT.getMsg());
        outputView.printResult(lottoGame.getResult());
        outputView.printProfit(getProfit());
    }

    public double getProfit() {
        return lottoGame.getProfit();
    }
}
