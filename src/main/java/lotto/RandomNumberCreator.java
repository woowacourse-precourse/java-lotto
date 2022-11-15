package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberCreator {
    public static List<Integer> createLotto() {
        List<Integer> number = Randoms.pickUniqueNumbersInRange(
                Constants.MIN,
                Constants.MAX,
                Constants.MAX_COUNT);
        return new ArrayList<>(number);
    }
}
