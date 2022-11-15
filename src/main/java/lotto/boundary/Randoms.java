package lotto.boundary;

import java.util.List;

public interface Randoms {
    static List<Integer> pickUniqueNumbersInRange(
            int startInclusive,
            int endInclusive,
            int count
    ) {
        return camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
