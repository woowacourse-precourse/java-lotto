package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(){
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> Get_Numbers(){
        return numbers;
    }
}
