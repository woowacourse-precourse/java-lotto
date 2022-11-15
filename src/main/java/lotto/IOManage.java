package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class IOManage {
    private final ControlLottoGame control = new ControlLottoGame();

    private int inputPrice;
    private int quantity;
    private List<List<Integer>> generatedLotto;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    IOManage() {
    }

    public boolean inputPayment() {
        System.out.println(Message.INPUT_PAYMENT.get());
        String input = Console.readLine();

        if (control.validateNumber(input)) {
            inputPrice = Integer.parseInt(input);
            return true;
        }
        return false;
    }

    public void outputLottoGeneration() {
        quantity = control.priceToQuantity(inputPrice);

        GenerateLotto generation = new GenerateLotto(quantity);
        generatedLotto = generation.getLottoNumbers();

        System.out.println(quantity + Message.OUTPUT_BUYING.get());
        for (List<Integer> lottoNumber : generatedLotto) {
            System.out.println(lottoNumber);
        }
    }

    public boolean inputWinningNumbers() {
        System.out.println(Message.INPUT_WINNING_NUMBER.get());

        String inputString = Console.readLine();
        List<Integer> numbers = control.inputToWinningNumbers(inputString);

        if (numbers.size() != 6) {
            return false;
        }

        Lotto lotto = new Lotto(numbers);
        numbers = lotto.getNumbers();
        winningNumbers = numbers;
        return true;
    }

    public boolean inputBonusNumber() {
        System.out.println(Message.INPUT_BONUS_NUMBER.get());

        String inputString = Console.readLine();
        bonusNumber = control.inputToBonusNumber(inputString, winningNumbers);

        if (bonusNumber == -1) {
            return false;
        }
        return true;
    }

    public void outputStatistic() {
        CheckWinningLotto check = new CheckWinningLotto();
        List<Integer> winningCount = check.totalWinningCount(generatedLotto, winningNumbers, bonusNumber);
        System.out.println(Message.OUTPUT_STATISTICS.get());

        System.out.println(Message.THREE_CORRECT.get() + winningCount.get(0) + Message.COUNT.get());
        System.out.println(Message.FOUR_CORRECT.get() + winningCount.get(1) + Message.COUNT.get());
        System.out.println(Message.FIVE_CORRECT.get() + winningCount.get(2) + Message.COUNT.get());
        System.out.println(Message.FIVE_BONUS_CORRECT.get() + winningCount.get(4) + Message.COUNT.get());
        System.out.println(Message.SIX_CORRECT.get() + winningCount.get(3) + Message.COUNT.get());
    }

    public void outputEarningRate() {
        CheckWinningLotto check = new CheckWinningLotto();
        List<Integer> winningCount = check.totalWinningCount(generatedLotto, winningNumbers, bonusNumber);
        double earningRate = control.calculateEarningRate(winningCount, quantity);
        System.out.println(Message.EARNING_RATE.get() + earningRate + Message.ENDING.get());
    }

    public void flowManage() {
        if (inputPayment()) {
            numberFlowManage();
        }
    }

    public void numberFlowManage() {
        outputLottoGeneration();

        if (inputWinningNumbers()) {
            if (inputBonusNumber()) {
                outputStatistic();
                outputEarningRate();
            }
        }
    }
}