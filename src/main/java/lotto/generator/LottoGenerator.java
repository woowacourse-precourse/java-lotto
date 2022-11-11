package lotto.generator;

import static lotto.constant.Constants.UNIT_OF_LOTTO_PURCHASE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoNumber;
import lotto.domain.Lotto;

public class LottoGenerator {

    public static List<Lotto> generateByMoney(int money) {
        int availableQuantity = calculateAvailableQuantity(money);
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int purchasingQuantity = 0; purchasingQuantity < availableQuantity; purchasingQuantity++) {
            purchasedLottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(
                    LottoNumber.START_NUMBER_OF_LOTTO.getNumber(),
                    LottoNumber.END_NUMBER_OF_LOTTO.getNumber(),
                    availableQuantity
            )));
        }

        return purchasedLottos;
    }

    private static int calculateAvailableQuantity(int money) {
        return money / UNIT_OF_LOTTO_PURCHASE;
    }
}
