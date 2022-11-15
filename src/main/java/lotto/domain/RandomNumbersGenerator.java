package lotto.domain;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class RandomNumbersGenerator {
    public static List<Integer> creatSixDifferentNumbers() {
        return pickUniqueNumbersInRange(1, 45, 6);
    }
}
