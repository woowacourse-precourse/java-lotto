package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {

    public Lotto buyLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
