package lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Randomizer {
    public List<Integer> randomizeLotto(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}
