package lotto.controller;

import lotto.domain.Lottos;
import lotto.view.InputManager;
import lotto.view.OutputManager;

import java.util.List;

public class LottoSystem {
    public LottoSystem() {
    }

    public void startProgram() {
        InputManager inputManager = new InputManager();

        int amount = inputManager.readPurchaseAmount();

        Lottos lottos = new Lottos();
        lottos.issueLottos(amount);

        OutputManager outputManager = new OutputManager();
        outputManager.printLottos(lottos);

        List<Integer> winningNumber = inputManager.readWinningNumber();


    }
}
