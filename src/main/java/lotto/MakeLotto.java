package lotto;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MakeLotto {
    public List<List<Integer>> makeLotto(int count) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < count; i ++){
            List<Integer> winLotto = Randoms.pickUniqueNumbersInRange(1,45,6);
            winLotto = winLotto.stream().sorted().collect(Collectors.toList());
            result.add(winLotto);
        }


        return result;
    }
}

