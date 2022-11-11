package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.RandomNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.ArrayList;

public class LottoGame {
    public void startLottoGame() {
        int quantity = getLottoPurchaseAmount();
        OutputView.printLottoPurchaseCompleteAmount(quantity);

        List<Lotto> purchaseLotto = buyLotto(quantity);
        OutputView.printLottoFormatting(purchaseLotto);
    }

    private int getLottoPurchaseAmount() {
        int quantity = InputView.getLottoPurchaseAmount() / 1000;
        return quantity;
    }

    private List<Lotto> buyLotto(int quantity) {
        List<Lotto> purchaseLotto = new ArrayList<>();
        RandomNumbers randomNumbers = new RandomNumbers();

        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = randomNumbers.generateRandomNumbers();
            Lotto lotto = new Lotto(numbers);
            purchaseLotto.add(lotto);
        }
        return purchaseLotto;
    }
}
