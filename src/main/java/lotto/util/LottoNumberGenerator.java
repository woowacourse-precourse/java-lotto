package lotto.util;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class LottoNumberGenerator {

    public static List<Integer> generateRandomNumbers(int startIdx, int endIdx, int numberCount){
        return pickUniqueNumbersInRange(startIdx, endIdx, numberCount);
    }
}
