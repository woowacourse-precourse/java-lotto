package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoCreator {
    public Lotto createLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        for (int i : numbers){
            System.out.println(i);
        }
        return new Lotto(numbers);
    }
}
