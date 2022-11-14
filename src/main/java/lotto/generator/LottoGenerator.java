package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoNumber;
import lotto.domain.Lotto;
import lotto.domain.Payment;

public class LottoGenerator {

    public static List<Lotto> generateByPayment(Payment payment) {
        int numberOfAvailablePurchases = payment.getNumberOfAvailablePurchases();
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int purchasingQuantity = 0; purchasingQuantity < numberOfAvailablePurchases; purchasingQuantity++) {
            purchasedLottos.add(
                    new Lotto(
                            Randoms.pickUniqueNumbersInRange(
                                    LottoNumber.START_NUMBER_OF_LOTTO.getNumber(),
                                    LottoNumber.END_NUMBER_OF_LOTTO.getNumber(),
                                    LottoNumber.NUMBER_OF_LOTTO_NUMBERS.getNumber()
                            )
                    )
            );
        }

        return purchasedLottos;
    }
}
