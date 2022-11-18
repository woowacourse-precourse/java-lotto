package lotto.controller;

import java.util.List;

import static lotto.console.Input.*;
import static lotto.console.Output.*;
import static lotto.service.Validation.isNonContains;

public class WinningLottoController {

    public List<Integer> createWinningLotto() {
        System.out.println();
        printInputWinningNumber();

        return inputSixNumber();
    }

    public void addBonusNumber(List<Integer> winningLotto) {
        System.out.println();
        printInputBonusNumber();

        int bonusNumber = inputNumber();
        isNonContains(winningLotto, bonusNumber);
        winningLotto.add(bonusNumber);
    }

    public List<Integer> runWinningLottoController() {
        List<Integer> winningLotto = createWinningLotto();
        addBonusNumber(winningLotto);

        return winningLotto;
    }
}