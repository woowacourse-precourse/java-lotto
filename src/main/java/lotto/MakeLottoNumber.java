package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MakeLottoNumber {

    private final List<Integer> Lottos;

    public MakeLottoNumber(List<Integer> Lottos) {
        this.Lottos = Lottos;
    }

    private List<Integer> getLottoNumber() {
        List<Integer> Lottos = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return Lottos;
    }

}
