package lotto.application.service.lottonumber;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGeneratorImpl implements LottoNumberGenerator {

    @Override
    public List<Lotto> generateLottoNumber(int purchaseMoney) {
        List<Lotto> lottoGroup = new ArrayList<>();

        for (int count = 0; count < (purchaseMoney / 1000); count++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);

            Lotto lotto = new Lotto(numbers);
            lottoGroup.add(lotto);
        }

        return lottoGroup;
    }
}
