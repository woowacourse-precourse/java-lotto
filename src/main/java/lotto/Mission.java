package lotto;

import static lotto.utils.Constant.LOTTO_PRICE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMaker;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.ResultRepository;
import lotto.domain.WinningLotto;
import lotto.view.Input;
import lotto.view.Output;

public class Mission {

    Output output;
    Input input;
    LottoMaker lottoMaker;
    ResultRepository repository;

    Mission() {
        output = new Output();
        input = new Input();
        lottoMaker = new LottoMaker();
        repository = new ResultRepository();

        play();
    }

    private void play() {
        Money money = getMoney();

        int many = calculateHowManyLotto(money);
        List<Lotto> lottos = lottoMaker.getLottos(many);
        output.printLottos(lottos);

        WinningLotto winningLotto = getWinningLotto();

        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.match(lotto);
            repository.add(rank);
        }

        int totalMoney = repository.getTotalMoney();
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
        return new WinningLotto(winningNumbers, bonusNumber);
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
