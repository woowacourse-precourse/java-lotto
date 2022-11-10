package lotto.Utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Random {

    public static List<Integer> makeRandomNumbers(){
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return randomNumbers;
    }
}
