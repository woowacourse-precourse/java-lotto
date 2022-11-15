package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CreateRandomList {
    public static List<Integer> createList(){
        List<Integer> random = new ArrayList<>();
        random = Randoms.pickUniqueNumbersInRange(1,45, 6);
        return random;
    }
}
