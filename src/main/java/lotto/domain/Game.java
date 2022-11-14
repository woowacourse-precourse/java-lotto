package lotto.domain;

import lotto.view.GameInput;
import lotto.view.GameOutput;

public class Game {

    private User user;
    private CalculationResult calculation;
    private LottoNumberGeneration generation;

    public Game() {
        user = new User();
        calculation = new CalculationResult();
        generation = new LottoNumberGeneration();
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
