package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberMaker {

    private final List<Integer> winningLotto;

    public LottoNumberMaker(List<Integer> winningLotto) {
        this.winningLotto = winningLotto;
    }

    private List<Integer> getLottoNumber() {
        List<Integer> winningLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return winningLotto;
    }

}
