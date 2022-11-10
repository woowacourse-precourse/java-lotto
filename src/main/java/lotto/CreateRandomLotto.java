package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateRandomLotto {
    public Map<Integer, List<Integer>> ramdomLotto(int counts){
        Map<Integer, List<Integer>> lottopaper = new HashMap<>();
        while(counts != 0){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottopaper.put(0, numbers);
            counts--;
        }
        return lottopaper;
    }
}
