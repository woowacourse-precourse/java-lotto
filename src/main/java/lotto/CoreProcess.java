package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class CoreProcess {

    public List<Integer> setLottoNumber() {
        List<Integer> LottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return LottoNumber;
    }



}

