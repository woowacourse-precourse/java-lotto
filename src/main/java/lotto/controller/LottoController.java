package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Calculator;
import lotto.model.Compare;
import lotto.model.Computer;
import lotto.model.enumeration.Exception;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private static final Computer computer = new Computer();
    private static final Compare compare = new Compare();
    private static final Calculator calculator = new Calculator();
    private static final int[] REWARD_LEVEL = {5000, 50000, 1500000, 30000000, 2000000000};

    public void init() {
        int inputMoney = purchaseLotto();
        List<List<Integer>> computerRandomNumbers = generateRandomNumbers(inputMoney);
        int[] result = compareLottoNumbers(inputMoney, computerRandomNumbers);
        createStatistic(inputMoney, result);
    }

    private int purchaseLotto() {
        OutputView.printLottoStart();

        return inputPurchaseMoney();
    }

    private int inputPurchaseMoney() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Exception.INVALID_INPUT_ONLY_NUMBER.getExceptionMessage());
        }
    }

    private List<List<Integer>> generateRandomNumbers(int inputMoney) {
        List<List<Integer>> computerRandomNumbers = computer.createRandomNumbers(inputMoney);
        OutputView.printNumberOfLotto(inputMoney);
        OutputView.printRandomNumbers(computerRandomNumbers);

        return computerRandomNumbers;
    }

    private int[] compareLottoNumbers(int inputMoney, List<List<Integer>> computerRandomNumbers) {
        OutputView.printLottoNumbers();
        List<Integer> lottoNumbers = inputLottoNumbers();
        OutputView.printBonusNumber();
        int bonusNumber = inputBonusNumber();

        return compare.getResult(inputMoney, computerRandomNumbers, lottoNumbers, bonusNumber);

    }

    private List<Integer> inputLottoNumbers() {
        String[] inputNumbers = Console.readLine().split(",");

        List<Integer> lottoNumbers = new ArrayList<>();

        for (String inputNumber: inputNumbers) {
            int lottonumber = Integer.parseInt(inputNumber);
            lottoNumbers.add(lottonumber);
        }
        return lottoNumbers;
    }

    private int inputBonusNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Exception.INVALID_INPUT_ONLY_NUMBER.getExceptionMessage());
        }
    }

    private void createStatistic(int inputMoney, int[] result) {
        int reward = calculator.getReward(REWARD_LEVEL, result);
        String rate = calculator.getRate(inputMoney, reward);

        OutputView.printStatistics(result);
        OutputView.printRate(rate);
    }
}
