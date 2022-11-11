package lotto.domain;

import java.util.List;

public class Player {
    private List<Lotto> lottos;

    public void issueLottos(int money) {
        int number = money /1000;

        for (int i = 0; i < number; i++) {
            List<Integer> lottoNumbers = LottoNumberGenerator.generate();
            lottos.add(new Lotto(lottoNumbers));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
