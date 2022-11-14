package lotto.controller;

import lotto.model.Computer;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private static final Computer computer = new Computer();

    public void init() {
        int inputMoney = purchaseLotto();
        List<List<Integer>> computerRandomNumbers = generateRandomNumbers(inputMoney);
        // compareLottoNumbers();
        // createStatistic();
    }

    private int purchaseLotto() {
        int inputNumber = InputView.getInputMoney();
        OutputView.printNumberofLotto(inputNumber);

        return inputNumber;
    }

    private List<List<Integer>> generateRandomNumbers(int inputMoney) {
        List<List<Integer>> computerRandomNumbers = computer.createRandomNumbers(inputMoney);
        OutputView.printRandomNumbers(computerRandomNumbers);

        return computerRandomNumbers;
    }
}
