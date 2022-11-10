package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateRandomLotto {
    public Map<Integer, List<List<Integer>>> randomLotto(int counts){
        Map<Integer, List<List<Integer>>> lottopaper = new HashMap<>();
        lottopaper.put(0, new ArrayList<>());
        while(counts != 0){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottopaper.get(0).add(numbers);
            counts--;
        }
        return lottopaper;
    }
}
