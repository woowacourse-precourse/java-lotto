package lotto.lotto;

import lotto.lotto.Lotto;
import lotto.lottonumber.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    List<Lotto> lottos = new ArrayList<>();

    public void issuedLottos(int amount) {
        for (int i = 0; i < amount; i++) {
            List<Integer> lottoNumbers = new ArrayList<>(LottoNumber.generate()); // 어레이 리스트 생성할 때 new 써주지않으면 예외발생
            Collections.sort(lottoNumbers);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
