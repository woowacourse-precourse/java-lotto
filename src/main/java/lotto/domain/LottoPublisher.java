package lotto.domain;

import static lotto.domain.constant.IntValueConstant.LOTTO_MAXIMUM_NUMBER;
import static lotto.domain.constant.IntValueConstant.LOTTO_MINIMUM_NUMBER;
import static lotto.domain.constant.IntValueConstant.LOTTO_NUMBER_OF_DIGITS;
import static lotto.domain.constant.PriceValueConstant.LOTTO;
import static lotto.exception.ExceptionHandler.AMOUNT_UNIT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoPublisher {

    private LottoPublisher() {
    }

    public static List<Lotto> publishLotto(Buyer buyer) {
        validateCorrectAmount(buyer.getMoney());

        List<Lotto> buyerLotto = new ArrayList<>();

        for (int i = 0; i < buyer.getMoney() / LOTTO.getPrice(); i++) {
            buyerLotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MINIMUM_NUMBER.getValue(),
                    LOTTO_MAXIMUM_NUMBER.getValue(), LOTTO_NUMBER_OF_DIGITS.getValue())));
        }

        return buyerLotto;
    }

    private static void validateCorrectAmount(Long money) {
        if (money % LOTTO.getPrice() != 0) {
            AMOUNT_UNIT.error();
        }
    }

}
