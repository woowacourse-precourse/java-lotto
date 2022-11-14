package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoManager {

    private final int[] rewards = new int[]{ Prize.FIFTH_PRIZE.getPrize(),
            Prize.SECOND_PRIZE.getPrize(),
            Prize.THIRD_PRIZE.getPrize(),
            Prize.FOURTH_PRIZE.getPrize(),
            Prize.FIFTH_PRIZE.getPrize() };
    private final Judge judge;
    private final LottoGenerator lottoGenerator;
    private List<Lotto> userLottos;
    private Lotto winningNumbers;
    private static String error;
    private final int[] prize = new int[]{ 0, 0, 0, 0, 0 };
    private int bonusNumber;
    private int amount;
    private float yield;

    public LottoManager() {
        this.judge = new Judge();
        this.lottoGenerator = new LottoGenerator();
    }

    public static void terminateByError(String error) {
        LottoManager.error = error;
        throw new IllegalArgumentException();
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
        System.out.println(Notice.INPUT_AMOUNT.getNotice());
        String buyAmount = Console.readLine();
        assignLottoAndAmount(buyAmount);
    }

    private void assignLottoAndAmount(String buyAmount) {
        lottoGenerator.amountIsNumber(buyAmount);
        userLottos = lottoGenerator.createLottoNumbers(buyAmount);
        amount = Integer.parseInt(buyAmount);
    }

    private void inputWinningNumbers() {
        System.out.println(Notice.INPUT_WINNING_NUMBERS.getNotice());
        String inputNumbers = Console.readLine();
        judge.isAllNumber(inputNumbers);
        winningNumbers = lottoGenerator.changeToNumber(inputNumbers);
    }

    private void inputBonusNumber() {
        System.out.println(Notice.INPUT_BONUS_NUMBER.getNotice());
        String bNumber = Console.readLine();
        if(judge.isNumber(bNumber)) {
            bonusNumber = Integer.parseInt(bNumber);
        }
    }

    private void checkContain() {
        judge.isNotContain(winningNumbers, bonusNumber);
    }

    private void isFirst(int correct) {
        if(correct == 6) {
            prize[0]++;
        }
    }
    private void isSecond(int correct, boolean bonus) {
        if(correct == 5 && bonus) {
            prize[1]++;
        }
    }

    private void isThird(int correct, boolean bonus) {
        if(correct == 5 && !bonus) {
            prize[2]++;
        }
    }

    private void isFourth(int correct) {
        if(correct == 4) {
            prize[3]++;
        }
    }

    private void isFifth(int correct) {
        if(correct == 3) {
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

    private void showAllLottos() {
        for(Lotto lotto : userLottos) {
            lotto.printSortedNumbers();
        }
    }

    private void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(String.format(Result.FIFTH.getResult(), prize[4]));
        System.out.println(String.format(Result.FOURTH.getResult(), prize[3]));
        System.out.println(String.format(Result.THIRD.getResult(), prize[2]));
        System.out.println(String.format(Result.SECOND.getResult(), prize[1]));
        System.out.println(String.format(Result.FIRST.getResult(), prize[0]));
        System.out.println(String.format(Result.YIELD.getResult(), yield));
    }
    public void gameStart() {
        try{
            inputAmount();
            showAllLottos();
            inputWinningNumbers();
            inputBonusNumber();
            checkContain();
            compare();
            calcYield();
            printResult();
        } catch(IllegalArgumentException e) {
            System.out.println(LottoManager.error);
        }
    }
}
