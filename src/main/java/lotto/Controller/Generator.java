package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Generator {

    private final List<Integer> lottoNumber;

    public Generator() {
        this.lottoNumber = lottoGenerator();
    }



    public List<Integer> getlottoNumbers() {
        return lottoNumber;
    }

    private List<Integer> lottoGenerator() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
