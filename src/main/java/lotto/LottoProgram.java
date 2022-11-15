package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoProgram {
    private final int LOTTO_PRICE = 1000;

    private int numberOfLotto = 0;
    private List<Lotto> lottos;

    public void progress() {
        buyLotto();
        makeLotto();
    }

    public void buyLotto() {
        OutputView.printInputMoneyMessage();

        String input = InputView.getMoney();
        int money = Integer.parseInt(input);
        this.numberOfLotto = countLottoQuantity(money);

        OutputView.printNumberOfLottoMessage(this.numberOfLotto);
    }

    public int countLottoQuantity(int money) {
        return money / LOTTO_PRICE;
    }

    public void makeLotto() {
        this.lottos = new ArrayList<>();

        for (int i = 0; i < this.numberOfLotto; i++) {
            List<Integer> numbers = LottoGenerator.generateLotto();
            Lotto lotto = new Lotto(numbers);
            lotto.printLottoNumbers();
            this.lottos.add(lotto);
        }
    }
}
