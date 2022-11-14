package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void printAnalysis(List<Lotto> lottos, int price) {

        Map<Prize, Integer> statistics = new HashMap<>();
        for (Lotto lotto : lottos) {
            statistics.merge(analysis(lotto), 1, (value, putValue) -> value + 1);
        }
        printStatistics(statistics);
    }

    private static void printStatistics(Map<Prize, Integer> statistics) {

        for (Prize prize : PRIZES) {
            prize.printPrize(statistics.getOrDefault(prize, 0));
        }
    }

}
