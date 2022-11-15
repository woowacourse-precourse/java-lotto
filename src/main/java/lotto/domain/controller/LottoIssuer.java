package lotto.domain.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.domain.model.Lotto;

public class LottoIssuer {

    public static final int PRICE_OF_LOTTO = 1000;

    public static List<Lotto> issueLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int numberOfLottos = purchaseAmount / PRICE_OF_LOTTO;

        for (int i = 0; i < numberOfLottos; i++) {
            Lotto oneLotto = issueOneLotto();

            lottos.add(oneLotto);
        }

        return lottos;
    }

    private static Lotto issueOneLotto() {
        List<Integer> oneLottoNumbers = new ArrayList<>(pickUniqueNumbersInRange(1, 45, 6));

        oneLottoNumbers.sort(Comparator.naturalOrder());

        return new Lotto(oneLottoNumbers);
    }
}
