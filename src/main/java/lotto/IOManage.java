package lotto;

import lotto.ControlLottoGame;
import lotto.Lotto;
import lotto.CheckWinningLotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class IOManage {
    private int inputPrice;
    private int quantity;
    private List<List<Integer>> generatedLotto;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void IOManage() {
    }

    public void inputPayment() {
        System.out.println(Message.INPUT_PAYMENT.get());
        String input = Console.readLine();
        int inputPrice = Integer.parseInt(input);

        this.inputPrice = inputPrice;
    }

    public void outputLottoGeneration() {
        ControlLottoGame control = new ControlLottoGame();
        int quantity = control.priceToQuantity(inputPrice);
        this.quantity = quantity;

        GenerateLotto generation = new GenerateLotto(quantity);
        List<List<Integer>> lottoNumbers = generation.getLottoNumbers();
        this.generatedLotto = lottoNumbers;

        System.out.println(quantity + Message.OUTPUT_BUYING.get());
        for (int i = 0; i < lottoNumbers.size(); i++) {
            System.out.println(lottoNumbers.get(i));
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
        ControlLottoGame control = new ControlLottoGame();
        CheckWinningLotto check = new CheckWinningLotto();
        System.out.println(Message.OUTPUT_STATISTICS.get());

        List<Integer> winningCount = check.winningIndexToCount(generatedLotto, winningNumbers, bonusNumber);
        System.out.println(winningCount);
        /* */
        float earningRate = control.calculateEarningRate(winningCount, quantity);

        System.out.println(Message.THREE_CORRECT.get() + winningCount.get(0) + Message.COUNT.get());
        System.out.println(Message.FOUR_CORRECT.get() + winningCount.get(1) + Message.COUNT.get());
        System.out.println(Message.FIVE_CORRECT.get() + winningCount.get(2) + Message.COUNT.get());
        System.out.println(Message.FIVE_BONUS_CORRECT.get() + winningCount.get(4) + Message.COUNT.get());
        System.out.println(Message.SIX_CORRECT.get() + winningCount.get(3) + Message.COUNT.get());

        System.out.println(Message.EARNING_RATE.get() + earningRate + Message.ENDING.get());
    }
}
