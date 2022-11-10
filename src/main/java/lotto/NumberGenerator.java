package lotto;

import static lotto.enums.Numbers.LOTTO_NUMBER_START;
import static lotto.enums.Numbers.LOTTO_NUMBER_END;
import static lotto.enums.Numbers.WINNING_NUMBER_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {

    public static List<Integer> createRandomNumber() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_START.getValue(), LOTTO_NUMBER_END.getValue(),
                WINNING_NUMBER_SIZE.getValue());
        sortAscending(randomNumbers);
        return randomNumbers;
    }

    private static void sortAscending(List<Integer> randomNumbers) {
        Collections.sort(randomNumbers);
    }

}
