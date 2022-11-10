package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.Constant;

public class LottoGenerator {

    public static List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>(generateNumbers());
        winningNumbers.addAll(generateBonusNumber());

        return winningNumbers;
    }

    private static List<Integer> generateBonusNumber() {
        return Randoms.pickUniqueNumbersInRange(
                Constant.LOTTO_START_NUMBER, Constant.LOTTO_END_NUMBER, Constant.BONUS_NUMBER_SIZE);
    }

    private static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                Constant.LOTTO_START_NUMBER, Constant.LOTTO_END_NUMBER, Constant.LOTTO_SIZE)
        );

        Collections.sort(numbers);

        return numbers;
    }

}
