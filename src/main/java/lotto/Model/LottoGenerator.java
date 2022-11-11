package lotto.Model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

public class LottoGenerator {
    public List<Lotto> createMyLottos(int lottoNumber) {
        List<Lotto> myLottos = new ArrayList<>();
        for (int i = 0; i < lottoNumber; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            myLottos.add(lotto);
        }

        return myLottos;
    }
}
