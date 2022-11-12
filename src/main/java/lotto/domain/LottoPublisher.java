package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoPublisher {

    public static final Long LOTTO_PRICE = 1_000L;
    public static final int LOTTO_MINIMUM_NUMBER = 1;
    public static final int LOTTO_MAXIMUM_NUMBER = 45;
    public static final int LOTTO_NUMBER_OF_DIGITS = 6;

    public static List<Lotto> publishLotto(Buyer buyer) {
        validateCorrectAmount(buyer.getMoney());

        List<Lotto> buyerLotto = new ArrayList<>();

        for (int i = 0; i < buyer.getMoney() / LOTTO_PRICE; i++) {
            buyerLotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER,
                    LOTTO_NUMBER_OF_DIGITS)));
        }

        return buyerLotto;
    }

    private static void validateCorrectAmount(Long money) {
        if (money % LOTTO_PRICE == 0) {
            throw new IllegalArgumentException("[ERROR]: 금액은 " + LOTTO_PRICE + "원 단위로 입력해야 합니다.");
        }
    }

}
