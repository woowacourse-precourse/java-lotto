package lotto;

import lotto.lottonumber.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    List<Lotto> lottos = new ArrayList<>();

    public void issuedLottos(int amount) {
        for (int i = 0; i < amount; i++) {
            List lottonumbers = LottoNumber.generate();
            Lotto lotto = new Lotto(lottonumbers);
            lottos.add(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
