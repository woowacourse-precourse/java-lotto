package lotto.util;

import static lotto.global.Constant.MAX_LOTTO_NUM;
import static lotto.global.Constant.MAX_LOTTO_SIZE;
import static lotto.global.Constant.MIN_LOTTO_NUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {

    public List<Integer> generateRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, MAX_LOTTO_SIZE);
        return numbers;
    }

}