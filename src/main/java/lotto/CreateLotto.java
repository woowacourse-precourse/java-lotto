package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class CreateLotto {
    final List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

    public List<Integer> createRandomBall() {
        return numbers;
    }
}
