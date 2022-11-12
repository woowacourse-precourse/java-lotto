package lotto.domain.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.domain.model.Lotto;

public class LottoIssuer {

    public List<Lotto> issueLottos(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            Lotto oneLotto = issueOneLotto();

            lottos.add(oneLotto);
        }

        return lottos;
    }

    private Lotto issueOneLotto() {
        List<Integer> oneLottoNumbers = pickUniqueNumbersInRange(1, 45, 6);
        oneLottoNumbers.sort(Comparator.naturalOrder());

        return new Lotto(oneLottoNumbers);
    }
}
