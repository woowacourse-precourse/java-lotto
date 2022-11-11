package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class CreateLotto {
    public List<Integer> CreateRandomBall() {
        return numbers;
    }
    List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
}
