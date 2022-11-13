package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomUtils {

    public static Lotto createRandomUserLotto(){
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        Lotto userLotto = new Lotto(numbers);
        return userLotto;
    }


}
