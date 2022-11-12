package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public List<Lotto> createLottoNumbers(int amount) {
        if(!Judge.correctAmount(amount)) {
            throw new IllegalArgumentException("1000으로 나누어 떨어지도록 해주세요.");
        }
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount / 1000; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }
}
