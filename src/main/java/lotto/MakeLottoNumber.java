package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MakeLottoNumber {

    private final List<Integer> Lotto;

    public MakeLottoNumber(List<Integer> Lotto) {
        this.Lotto = Lotto;
    }

    private List<Integer> getLottoNumber() {
        List<Integer> Lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return Lotto;
    }

}
