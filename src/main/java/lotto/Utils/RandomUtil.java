package lotto.Utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class RandomUtil {

    public static List<Integer> makeRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
