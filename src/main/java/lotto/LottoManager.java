package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    private final int FIRST_PRIZE = 2_000_000_000;
    private final int SECOND_PRIZE = 30_000_000;
    private final int THIRD_PRIZE = 1500000;
    private final int FOURTH_PRIZE = 50000;
    private final int FIFTH_PRIZE = 5000;
    private int[] prize = new int[]{ 0, 0, 0, 0, 0 };
    private final int[] rewards = new int[]{ FIRST_PRIZE, SECOND_PRIZE, THIRD_PRIZE, FOURTH_PRIZE, FIFTH_PRIZE };
    private final Judge judge;
    private final LottoGenerator lottoGenerator;
    private List<Lotto> userLottos;
    private Lotto winningNumbers;
    private int bonusNumber;
    private int amount;
    private float yield;

    public LottoManager() {
        this.judge = new Judge();
        this.lottoGenerator = new LottoGenerator();
    }

    public void compare() {
        int correct;
        boolean bonus;
        for(Lotto lotto : userLottos) {
            correct = judge.containCount(lotto.getNumbers(), winningNumbers.getNumbers());
            bonus = lotto.getNumbers().contains(bonusNumber);
            checkResult(correct, bonus);
        }
    }
    public void inputAmount() {
        System.out.println(Notice.INPUT_AMOUNT.getNotice());
        String buyAmount = Console.readLine();
        assignLottoAndAmount(buyAmount);
    }

    private void assignLottoAndAmount(String buyAmount) {
        lottoGenerator.amountIsNumber(buyAmount);
        userLottos = lottoGenerator.createLottoNumbers(buyAmount);
        amount = Integer.parseInt(buyAmount);
    }

    public void inputWinningNumbers() {
        System.out.println(Notice.INPUT_WINNING_NUMBERS.getNotice());
        winningNumbers = lottoGenerator.changeToNumber(Console.readLine());
    }

    public void inputBonusNumber() {
        System.out.println(Notice.INPUT_BONUS_NUMBER.getNotice());
        String bNumber = Console.readLine();
        if(judge.isNumber(bNumber)) {
            bonusNumber = Integer.parseInt(bNumber);
        }
    }

    public void checkContain() {
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

    public void calcYield() {
        float total = 0;
        for (int i = 0; i < prize.length; i++) {
            total += prize[i] * rewards[i];
        }
        yield = (total / amount) * 100;
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + prize[4] + "개");
        System.out.println("4개 일치 (50,000원) - " + prize[3] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prize[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prize[1] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prize[0] + "개");
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", yield));
    }
}
