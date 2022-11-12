package lotto.domain.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.model.Lotto;

public class LottoIssuer {

    public List<Lotto> issueLottos(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> oneLottoNumbers = pickUniqueNumbersInRange(1, 45, 6);

            lottos.add(new Lotto(oneLottoNumbers));
        }

        return lottos;
    }
}
