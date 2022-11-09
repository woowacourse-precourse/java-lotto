package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        LottoNumber lottoNumber = new LottoNumber();
        int number = lottoNumber.getLottoNumber();
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            lottos.add(new Lotto(setLotto()));
        }

        this.lottos = lottos;
    }

    private List<Integer> setLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
