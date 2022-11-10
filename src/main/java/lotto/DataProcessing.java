package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class DataProcessing {
    public List<Integer> lottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        System.out.println(numbers);
        return numbers;
    }
}