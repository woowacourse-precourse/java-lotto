package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRule;

public class LottoShop {

    public List<Lotto> buy(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int cnt = 0; cnt < lottoCount; cnt++) {
            lottos.add(issueLotto());
        }

        return lottos;
    }

    private Lotto issueLotto() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                LottoRule.START_NUMBER.getValue(), LottoRule.END_NUMBER.getValue(), LottoRule.SIZE.getValue()));
        lottoNumbers.sort(Comparator.naturalOrder());
        return new Lotto(lottoNumbers);
    }

}
