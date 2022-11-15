package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberMaker {

    private final List<Integer> lotto;

    public LottoNumberMaker(List<Integer> lotto) {
        this.lotto = lotto;
    }

    private List<Integer> getLottoNumber() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lotto;
    }

}
