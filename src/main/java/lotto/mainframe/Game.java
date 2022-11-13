package lotto.mainframe;

import lotto.view.GameInput;
import lotto.view.GameOutput;

public class Game {

    private User user;
    private Calculation calculation;
    private LottoNumberGenerate generation;

    public Game() {
        user = new User();
        calculation = new Calculation();
        generation = new LottoNumberGenerate();
    }

    public void start() {
        GameInput.getUserMoneyInput();
        GameOutput.printBuyMessage(user.getLottoAmount());
        generation.generateLotto(user.getLottoAmount());
        GameOutput.printLottoNumbers(user.getLotteries());
        GameInput.getUserNumberInput();
        GameInput.getUserBonusNumberInput();
        calculation.calculateResult(user.getLotteries(), user.getUserInputBonusNumber(),
                user.getUserInputNumber());
        calculation.printResult();
    }
}
