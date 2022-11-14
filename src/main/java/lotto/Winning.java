package lotto;

import java.util.List;

import static lotto.Prize.*;

public class Winning {
    private static final Prize[] PRIZES = {FIFTH, FORTH, THIRD, SECOND, FIRST};
    private final List<Integer> numbers;
    private final int bonusNumber;

    Winning(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Prize analysis(Lotto lotto) { //등수로 return
        int cnt = 0;
        boolean bonus = false;
        List<Integer> myNumbers = lotto.getNumbers();
        for (Integer myNumber : myNumbers) {
            if (numbers.contains(myNumber)) cnt++;
        }
        if (numbers.contains(bonusNumber)) bonus = true;
        if (cnt == 6) return FIRST;
        if (cnt == 5 && bonus) return SECOND;
        if (cnt == 5) return THIRD;
        if (cnt == 4) return FORTH;
        if (cnt == 3) return FIFTH;
        return NOTHING;
    }

}
