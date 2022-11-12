package lotto;

import static lotto.utils.Constant.LOTTO_PRICE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMaker;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
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
        output.printLottos(lottos);

        WinningLotto winningLotto = getWinningLotto();


    }

    private Money getMoney() {
        output.printGetMoney();
        return input.getMoney();
    }

    private int calculateHowManyLotto(Money money) {
        return money.getMoney() / LOTTO_PRICE;
    }

    private WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = addBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        return winningLotto;
    }

    private List<Integer> getWinningNumbers() {
        output.printGetWinningNumbers();
        return input.getWinningNumbers();
    }

    private int addBonusNumber() {
        output.pringGetWinningBonusNumber();
        return input.getWinningBonusNumber();
    }
}
