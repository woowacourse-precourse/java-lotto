package lotto.domain;

import lotto.Enum.Prize;
import lotto.Lotto;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class LottoManager {

    private final int[] rewards = new int[]{
            Prize.FIRST_PRIZE.getPrize(),
            Prize.SECOND_PRIZE.getPrize(),
            Prize.THIRD_PRIZE.getPrize(),
            Prize.FOURTH_PRIZE.getPrize(),
            Prize.FIFTH_PRIZE.getPrize()
    };
    private final int[] prize = new int[]{ 0, 0, 0, 0, 0 };
    private List<Lotto> userLottos;
    private Lotto winningNumbers;
    private Judge judge;
    private LottoGenerator lottoGenerator;
    private Output output;
    private Input input;
    private static String error;
    private int bonusNumber;
    private int amount;
    private float yield;

    public LottoManager() {
        this.input = new Input();
        this.output = new Output();
        this.lottoGenerator = new LottoGenerator();
        this.judge = new Judge();
    }

    private void compare() {
        int correct;
        boolean bonus;
        for(Lotto lotto : userLottos) {
            correct = judge.containCount(lotto.getNumbers(), winningNumbers.getNumbers());
            bonus = lotto.getNumbers().contains(bonusNumber);
            checkResult(correct, bonus);
        }
    }

    private void inputAmount() {
        String buyAmount = input.amount();
        assignLottoAndAmount(buyAmount);
    }

    private void assignLottoAndAmount(String buyAmount) {
        judge.amountIsValid(buyAmount);
        userLottos = lottoGenerator.createLottoNumbers(buyAmount);
        amount = Integer.parseInt(buyAmount);
    }

    private void inputWinningNumbers() {
        String inputNumbers = input.winningNumbers();
        judge.isAllNumber(inputNumbers);
        winningNumbers = lottoGenerator.changeToNumber(inputNumbers);
    }

    private void inputBonusNumber() {
        String bNumber = input.bonusNumber();
        judge.isNumber(bNumber);
        bonusNumber = Integer.parseInt(bNumber);
    }

    private void checkContain() {
        judge.isNotContain(winningNumbers, bonusNumber);
    }

    private void isFirst(int correct) {
        if(correct == Prize.FIRST_PRIZE.getContained()) {
            prize[0]++;
        }
    }
    private void isSecond(int correct, boolean bonus) {
        if(correct == Prize.SECOND_PRIZE.getContained() && bonus) {
            prize[1]++;
        }
    }

    private void isThird(int correct, boolean bonus) {
        if(correct == Prize.THIRD_PRIZE.getContained() && !bonus) {
            prize[2]++;
        }
    }

    private void isFourth(int correct) {
        if(correct == Prize.FOURTH_PRIZE.getContained()) {
            prize[3]++;
        }
    }

    private void isFifth(int correct) {
        if(correct == Prize.FIFTH_PRIZE.getContained()) {
            prize[4]++;
        }
    }

    private void checkResult(int correct, boolean bonus) {
        isFirst(correct);
        isSecond(correct, bonus);
        isThird(correct, bonus);
        isFourth(correct);
        isFifth(correct);
    }

    private void calcYield() {
        float total = 0;
        for (int i = 0; i < prize.length; i++) {
            total += prize[i] * rewards[i];
        }
        yield = (total / amount) * 100;
    }
    public void gameStart() {
        try{
            inputAmount();
            output.showAllLottos(userLottos);
            inputWinningNumbers();
            inputBonusNumber();
            checkContain();
            compare();
            calcYield();
            output.printResult(prize, yield);
        } catch(IllegalArgumentException e) {
            output.printError(e.getMessage());
        }
    }
}
