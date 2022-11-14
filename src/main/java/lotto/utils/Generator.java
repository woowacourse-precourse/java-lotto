package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Prize;

public class Generator {
    public static List<Integer> makeRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static Map<Prize,Integer> makeNewPrizeMap() {
        Map<Prize, Integer> newPrizeMap = new HashMap<>();
        newPrizeMap.put(Prize.FIRST,0);
        newPrizeMap.put(Prize.SECOND,0);
        newPrizeMap.put(Prize.THIRD,0);
        newPrizeMap.put(Prize.FOURTH,0);
        newPrizeMap.put(Prize.FIFTH,0);
        newPrizeMap.put(Prize.NONE,0);
        return newPrizeMap;
    }
}
