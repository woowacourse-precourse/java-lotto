package lotto.domain;

import static lotto.constant.SystemValue.LOTTERY_NUMBERS_SIZE;
import static lotto.constant.SystemValue.MAXIMUM_LOTTERY_NUMBER;
import static lotto.constant.SystemValue.MINIMUM_LOTTERY_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LotteryDrawMachine {

    public List<Integer> drawLotteryNumbers() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTERY_NUMBER, MAXIMUM_LOTTERY_NUMBER, LOTTERY_NUMBERS_SIZE);
    }
}
