package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomUtil {
    public List<Integer> makeRandomNumber(){
        List<Integer> list = Randoms.pickUniqueNumbersInRange(1,45,6);
        return list;
    }
}
