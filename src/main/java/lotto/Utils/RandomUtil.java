package lotto.Utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomUtil {

    public static List<Integer> makeRandomNumbers(){
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return randomNumbers;
    }
}
