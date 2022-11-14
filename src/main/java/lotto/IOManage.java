package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Pattern;

public class IOManage {
    private int inputPrice;
    private int quantity;
    private List<List<Integer>> generatedLotto;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    IOManage() {
        if (inputPayment()) {
            outputLottoGeneration();
            inputWinningNumbers();
            inputBonusNumber();
            outputStatistic();
            outputEarningRate();
        }
    }

    public boolean inputPayment() {
        System.out.println(Message.INPUT_PAYMENT.get());
        String input = Console.readLine();
        try {
            if (!Pattern.matches("^[0-9]*$", input)) {
                throw new IllegalArgumentException(Message.ERROR.get() + Message.ERROR_INCORRECT_RANGE.get());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        inputPrice = Integer.parseInt(input);
        return true;
    }

    public void outputLottoGeneration() {
        ControlLottoGame control = new ControlLottoGame();
        quantity = control.priceToQuantity(inputPrice);

        GenerateLotto generation = new GenerateLotto(quantity);
        generatedLotto = generation.getLottoNumbers();

        System.out.println(quantity + Message.OUTPUT_BUYING.get());
        for (List<Integer> lottoNumber : generatedLotto) {
            System.out.println(lottoNumber);
        }
    }

    public void inputWinningNumbers() {
        ControlLottoGame control = new ControlLottoGame();
        System.out.println(Message.INPUT_WINNING_NUMBER.get());

        String inputString = Console.readLine();
        List<Integer> winningNumbers = control.inputToWinningNumbers(inputString);

        Lotto lotto = new Lotto(winningNumbers);
        winningNumbers = lotto.getNumbers();
        this.winningNumbers = winningNumbers;
    }

    public void inputBonusNumber() {
        ControlLottoGame control = new ControlLottoGame();
        System.out.println(Message.INPUT_BONUS_NUMBER.get());

        String inputString = Console.readLine();
        this.bonusNumber = control.inputToBonusNumber(inputString, winningNumbers);
    }

    public void outputStatistic() {
        CheckWinningLotto check = new CheckWinningLotto();
        System.out.println(Message.OUTPUT_STATISTICS.get());

        List<Integer> winningCount = check.totalWinningCount(generatedLotto, winningNumbers, bonusNumber);

        System.out.println(Message.THREE_CORRECT.get() + winningCount.get(0) + Message.COUNT.get());
        System.out.println(Message.FOUR_CORRECT.get() + winningCount.get(1) + Message.COUNT.get());
        System.out.println(Message.FIVE_CORRECT.get() + winningCount.get(2) + Message.COUNT.get());
        System.out.println(Message.FIVE_BONUS_CORRECT.get() + winningCount.get(4) + Message.COUNT.get());
        System.out.println(Message.SIX_CORRECT.get() + winningCount.get(3) + Message.COUNT.get());
    }

    public void outputEarningRate() {
        ControlLottoGame control = new ControlLottoGame();
        CheckWinningLotto check = new CheckWinningLotto();
        List<Integer> winningCount = check.totalWinningCount(generatedLotto, winningNumbers, bonusNumber);
        float earningRate = control.calculateEarningRate(winningCount, quantity);
        System.out.println(Message.EARNING_RATE.get() + earningRate + Message.ENDING.get());
    }
}
