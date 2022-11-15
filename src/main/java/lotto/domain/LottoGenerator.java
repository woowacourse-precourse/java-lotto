package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {
    public List<Integer> createLotto(){
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> numbers = new ArrayList<>(randomNumbers);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
