package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGenerator {

    public List<Integer> makeNumber(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
