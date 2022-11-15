package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoCashier {
    private static final String VALIDATE_UNIT_MASSAGE = "[ERROR] 1000원 단위로 구입해야 합니다.";

    public int getLottoCount(int money) {
        if (money > 0 || money % 1000 != 0) {
            throw new IllegalArgumentException(VALIDATE_UNIT_MASSAGE);
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
