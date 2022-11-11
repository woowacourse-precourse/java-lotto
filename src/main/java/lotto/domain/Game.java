package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    public static List<List<Integer>> makeLotto(int size) {
        List<List<Integer>> lottoList = new ArrayList<List<Integer>>();
        lottoList.add(Arrays.asList(0));
//        for (int i = 0; i < size; i++) {
//            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//            Lotto lotto = new Lotto(numbers);
//        }
        return lottoList;
    }
}
