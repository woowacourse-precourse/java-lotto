package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoManager {

    private final int FIRST_PRIZE = 2_000_000_000;
    private final int SECOND_PRIZE = 30_000_000;
    private final int THIRD_PRIZE = 1500000;
    private final int FOURTH_PRIZE = 50000;
    private final int FIFTH_PRIZE = 5000;
    private int[] prize = new int[]{ 0, 0, 0, 0, 0, 0 };
    private int[] rewards = new int[]{ FIRST_PRIZE, SECOND_PRIZE, THIRD_PRIZE, FOURTH_PRIZE, FIFTH_PRIZE };
    private final Judge judge;
    private final LottoGenerator lottoGenerator;
    private int amount;
    private float yield;

    public LottoManager() {
        this.judge = new Judge();
        this.lottoGenerator = new LottoGenerator();
    }

    public void compare(List<Lotto> lottoList, Lotto winningNumbers, int bonusNumber) {
        int correct;
        boolean bonus;
        for(Lotto lotto : lottoList) {
            correct = judge.containCount(lotto.getNumbers(), winningNumbers.getNumbers());
            bonus = lotto.getNumbers().contains(bonusNumber);
            checkResult(correct, bonus);
        }
    }

    public void inputAmount() {
        System.out.println(Notice.INPUT_AMOUNT.getNotice());
        String a = Console.readLine();
        lottoGenerator.createLottoNumbers(a);
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

    public void checkResult(int correct, boolean bonus) {
        isFirst(correct);
        isSecond(correct, bonus);
        isThird(correct, bonus);
        isFourth(correct);
        isFifth(correct);
    }

    private void calcYield() {
        int total = 0;
        for (int i = 0; i < prize.length; i++) {
            total += prize[i] * rewards[i];
        }
        yield = (total / amount) * 100;
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("3개 일치 (5,000원) - " + prize[4] + "개");
        System.out.println("4개 일치 (50,000원) - " + prize[3] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prize[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prize[1] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prize[0] + "개");
        System.out.println(String.format("총 수익률은 %.2f입니다.", yield));
    }
}
