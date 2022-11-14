package lotto.controller;

import lotto.model.Compare;
import lotto.model.Computer;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private static final Computer computer = new Computer();
    private static final Compare compare = new Compare();

    public void init() {
        int inputMoney = purchaseLotto();
        List<List<Integer>> computerRandomNumbers = generateRandomNumbers(inputMoney);
        int[] result = compareLottoNumbers(inputMoney, computerRandomNumbers);
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

    private int[] compareLottoNumbers(int inputMoney, List<List<Integer>> computerRandomNumbers) {

        String[] numbers = InputView.getNumbers();
        int bonusNumber = InputView.getBonusNumber();

        int[] result = compare.getResult(inputMoney, computerRandomNumbers, numbers, bonusNumber);

        return result;
    }

}
