package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Pick {
    public int cont;
    public List<Integer> numbers;

    public List<Integer> RandomNumber6() {
        numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return numbers;
    }
}
