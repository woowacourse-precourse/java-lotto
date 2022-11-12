package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import java.util.*;
public class NumberGenerator {

    public List<Integer> generateRandomNum(int start, int end, int count){
        return pickUniqueNumbersInRange(start, end, count);
    }

}
