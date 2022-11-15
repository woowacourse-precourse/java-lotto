package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.constants.ErrorMessage;
import lotto.domain.constants.LottoRule;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private LottoSeller() { }

    public static List<Lotto> issueLottosByAmount(int amount) throws IllegalArgumentException {
        validateIssueAmount(amount);
        List<Lotto> purchasedLottos = new ArrayList<>();
        while (purchasedLottos.size() < amount) {
            List<Integer> randomNumbers = generateLottoNumbersByRandom();
            purchasedLottos.add(new Lotto(randomNumbers));
        }
        return purchasedLottos;
    }

    private static void validateIssueAmount(int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_INSUFFICIENT.getValue());
        }
    }

    private static List<Integer> generateLottoNumbersByRandom() {
        int startInclusive = LottoRule.MINIMUM_NUMBER.getValue();
        int endInclusive = LottoRule.MAXIMUM_NUMBER.getValue();
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, 6);
    }
}
