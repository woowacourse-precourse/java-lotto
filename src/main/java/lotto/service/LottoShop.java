package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRule;

public class LottoShop {

    private static final int UNIT_PRICE = 1_000;

    public List<Lotto> buy(int purchasePrice) {
        validate(purchasePrice);
        int lottoCount = purchasePrice / UNIT_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int cnt = 0; cnt < lottoCount; cnt++) {
            lottos.add(issueLotto());
        }

        return lottos;
    }

    private void validate(int purchasePrice) {
        if (purchasePrice < UNIT_PRICE) {
            throw new IllegalArgumentException("입력값이 " + UNIT_PRICE + "보다 낮습니다. 로또를 구매할 수 없습니다.");
        }

        if (purchasePrice % UNIT_PRICE != 0) {
            throw new IllegalArgumentException("입력값이 " + UNIT_PRICE + "으로 나누어떨어지지 않습니다.");
        }
    }

    private Lotto issueLotto() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                LottoRule.START_NUMBER.getValue(), LottoRule.END_NUMBER.getValue(), LottoRule.SIZE.getValue()));
        lottoNumbers.sort(Comparator.naturalOrder());
        return new Lotto(lottoNumbers);
    }

}
