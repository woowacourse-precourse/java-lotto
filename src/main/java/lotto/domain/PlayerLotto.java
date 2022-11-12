package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerLotto {

    private List<Lotto> lottos;

    public void issue(LottoPurchaseMoney lottoPurchaseMoney) {
        int number = lottoPurchaseMoney.getMoney() / LottoPurchaseMoney.LOTTO_PRICE;

        lottos = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            List<Integer> lottoNumbers = LottoNumberGenerator.generate();
            lottos.add(new Lotto(lottoNumbers));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
