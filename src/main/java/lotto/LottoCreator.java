package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoCreator {
    public Lotto createRandomLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
