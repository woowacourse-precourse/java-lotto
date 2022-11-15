package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoProgram {
    private final int LOTTO_PRICE = 1000;

    private int numberOfLotto = 0;
    private List<Lotto> lottos = new ArrayList<>();
    private Lotto winningLotto;
    private int bonusNumber;

    public void progress() {
        buyLotto();
        makeLotto();
        getWinningLottoNumbers();
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
        for (int i = 0; i < this.numberOfLotto; i++) {
            List<Integer> numbers = LottoGenerator.generateLotto();
            Lotto lotto = new Lotto(numbers);
            lotto.printLottoNumbers();
            this.lottos.add(lotto);
        }
    }

    public void getWinningLottoNumbers() {
        OutputView.printInputWinningNumbersMessage();
        makeWinningLotto(InputView.getLottoNumbers());

        OutputView.printInputBonusNumbersMessage();
        makeBonusNumber(InputView.getBonusNumber());
    }

    private void makeWinningLotto(String numbers) {
        String[] lottoNumbers = numbers.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String s: lottoNumbers) {
            winningNumbers.add(Integer.parseInt(s));
        }
        this.winningLotto = new Lotto(winningNumbers);
    }

    private void makeBonusNumber(String bonusNumber) {
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }
}
