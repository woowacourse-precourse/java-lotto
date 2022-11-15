package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constant.*;
import static lotto.Validate.canBuyLotto;
import static lotto.Validate.isInteger;

public class LottoTicket {
    public List<Lotto> buy(String input) {
        List<Lotto> lottos = new ArrayList<>();
        int money = isInteger(input);
        canBuyLotto(money);

        for (int ticket = ZERO; ticket < money / PRICE_OF_A_TICKET; ticket++) {
            List<Integer> numbers = Randoms
                    .pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_SIZE);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }
}
