package lotto.controller;

import static lotto.utils.Constant.LOTTO_PRICE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMaker;
import lotto.domain.Money;
import lotto.view.Input;
import lotto.view.Output;

public class Mission {

    Output output;
    Input input;
    LottoMaker lottoMaker;

    Mission() {
        output = new Output();
        input = new Input();
        lottoMaker = new LottoMaker();

        play();
    }

    private void play() {
        Money money = getMoney();

        int many = calculateHowManyLotto(money);
        List<Lotto> lottos = lottoMaker.getLottos(many);

        Lotto winningLotto = getWinningLotto();


    }

    private Money getMoney() {
        output.printGetMoney();
        return input.getMoney();
    }

    private int calculateHowManyLotto(Money money) {
        return money.getMoney() / LOTTO_PRICE;
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
