package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.view.Input;
import lotto.view.Output;

public class Mission {

    Output output;
    Input input;

    Mission() {
        output = new Output();
        input = new Input();

        play();
    }

    private void play() {
        Money money = getMoney();
        Lotto winningLotto = getWinningLotto();


    }

    private Money getMoney() {
        output.printGetMoney();
        return input.getMoney();
    }

    private Lotto getWinningLotto() {
        Lotto winningLotto = getWinningNumbers();
        addBonusNumber(winningLotto);
        return winningLotto;
    }

    private Lotto getWinningNumbers() {
        output.printGetWinningNumbers();
        return input.getWinningNumbers();
    }

    private void addBonusNumber(Lotto lotto) {
        output.pringGetWinningBonusNumber();
        input.getWinningBonusNumber(lotto);
    }
}
