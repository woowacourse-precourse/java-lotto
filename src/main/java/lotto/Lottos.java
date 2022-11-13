package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import constants.LottoConstants;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int purchaseCount) {
        generateLottos(purchaseCount);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private void generateLottos(int purchaseCount) {
        while (purchaseCount > 0) {
            List<Integer> lotteryNumbers = Randoms.pickUniqueNumbersInRange(
                    LottoConstants.MIN_LOTTO_VALUE,
                    LottoConstants.MAX_LOTTO_VALUE,
                    LottoConstants.LOTTO_NUM);

            lottos.add(new Lotto(lotteryNumbers));
            purchaseCount--;
        }
    }
}
