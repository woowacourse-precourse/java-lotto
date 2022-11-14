package lotto.domain;

import static lotto.util.NumberValidator.*;

import java.util.List;
import lotto.util.NumberValidator;

public class Player {

    private final List<Integer> numbers;
    private int bonusNumber;

    public Player(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        checkSize(numbers);
        checkDuplicate(numbers);
        numbers.forEach(NumberValidator::checkRange);
        checkRange(bonusNumber);
    }


    public void compare(PrizeCount prizeCount, List<Lotto> lottos, int lottoBonusNumber) {
        boolean hasBonusNumber;

        for (Lotto lotto : lottos) {
            hasBonusNumber = Boolean.FALSE;

            if (isEqualBonusNumber(lottoBonusNumber)) {
                hasBonusNumber = Boolean.TRUE;
            }
            System.out.println("lotto = " + lotto.getMatchingNumber(numbers)+ hasBonusNumber);
            prizeCount.add(Prize.findPrize(lotto.getMatchingNumber(numbers), hasBonusNumber));
        }

    }

    public boolean isEqualBonusNumber(int lottoBonusNumber) {
        return (this.bonusNumber == lottoBonusNumber);
    }

}
