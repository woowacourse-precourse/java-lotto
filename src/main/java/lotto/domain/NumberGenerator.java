package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.Constants.Lotto_Size;

public class NumberGenerator {
    public List<Integer> createRandomNums(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, Lotto_Size);
        return numbers;
    }
}
