package lotto.controller;

import lotto.domain.RandomNumbersGenerator;
import lotto.view.InputView;
import java.util.List;

public class Game {
    public void startLottoGame() {
        int money = InputView.inputLottoAmount();
        RandomNumbersGenerator randomNumbers = new RandomNumbersGenerator();
        List<Integer> lottoNumbers = randomNumbers.createRandomNumbers();
    }
}
