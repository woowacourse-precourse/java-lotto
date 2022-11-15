package lotto.domain;

import java.util.List;

public class Calculator {
    private final Lotto winningLotto;
    private final int bonusNumber;
    private final Result result;

    public Calculator(List<Integer> winningNumbers, int bonusNumber) {
        winningLotto = new Lotto(winningNumbers);

        if (!Lotto.isInRange(bonusNumber)) {
            System.out.println(Lotto.RANGE_ERROR);
            throw new IllegalArgumentException();
        }

        if (Lotto.isDuplicate(winningNumbers, bonusNumber, 0)) {
            System.out.println(Lotto.DUPLICATE_ERROR);
            throw new IllegalArgumentException();
        }

        this.bonusNumber = bonusNumber;
        result = new Result();
    }

    public Result getResult() {
        return result;
    }

    public void compare(Lotto lotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        List<Integer> numbers = lotto.getNumbers();

        int count = 0;
        for (int winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                count++;
            }
        }

        if (count == 5 && numbers.contains(bonusNumber)) {
            result.addFiveBonus();
            return;
        }
        result.add(count);
    }

    public void printReturnRate(int money) {
        System.out.printf("총 수익률은 %.1f", returnRate(money));
        System.out.println("%입니다.");
    }

    public double returnRate(int money) {
        double revenue = result.getRevenue();
        return revenue / money * 100;
    }
}
