package lotto.domain.generator;

import static lotto.constant.SystemValue.LOTTERY_NUMBERS_SIZE;
import static lotto.constant.SystemValue.MAXIMUM_LOTTERY_NUMBER;
import static lotto.constant.SystemValue.MINIMUM_LOTTERY_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateNumbers() {
        List<Integer> lotteryNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTERY_NUMBER, MAXIMUM_LOTTERY_NUMBER,
                LOTTERY_NUMBERS_SIZE);
        return getSortedNumbers(lotteryNumbers);
    }

    private List<Integer> getSortedNumbers(List<Integer> lotteryNumbers) {
        return lotteryNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
