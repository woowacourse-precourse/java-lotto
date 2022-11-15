package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoCashier {
    public int getLottoCount(int money) {
        if (money > 0 && money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 구입해야 합니다.");
            }
        return money / 1000;
    }

    public List<Lotto> createLottoList(int count) {
        List<Lotto> purchasedLotto = new ArrayList<>();
        RandomNumbersGenerator randomNumbers = new RandomNumbersGenerator();

        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = randomNumbers.createRandomNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            purchasedLotto.add(lotto);
        }
        return purchasedLotto;
    }
}
