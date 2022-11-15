package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerLotto {

    private final List<Lotto> lottos;

    public PlayerLotto(LottoPurchaseMoney lottoPurchaseMoney) {
        this.lottos = issue(lottoPurchaseMoney);
    }

    public List<Lotto> issue(LottoPurchaseMoney lottoPurchaseMoney) {
        int number = lottoPurchaseMoney.getMoney() / LottoPurchaseMoney.LOTTO_PRICE;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            List<Integer> lottoNumbers = LottoNumberGenerator.generate();
            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
