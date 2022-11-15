package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    public Lotto pickNumber(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
    }

}
