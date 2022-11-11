package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.RandomNumbers;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
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
