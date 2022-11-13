package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GenerateLotto {
    public List<Integer> createLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }
}
