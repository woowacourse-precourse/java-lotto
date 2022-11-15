package lotto.controller;

import java.util.List;

import static lotto.console.Input.*;
import static lotto.console.Output.*;

public class WinningLottoController {

    public List<Integer> createWinningLotto() {
        printInputWinningNumber();

        return inputSixNumber();
    }

    public void addBonusNumber(List<Integer> winningLotto) {
        printInputBonusNumber();

        int bonusNumber = inputNumber();

        if(winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 이 보너스 번호는 유효하지 않습니다.");
        }

        winningLotto.add(bonusNumber);
    }

    public List<Integer> runWinningLottoController() {
        List<Integer> winningLotto = createWinningLotto();
        addBonusNumber(winningLotto);

        return winningLotto;
    }
}