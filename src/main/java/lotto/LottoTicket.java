package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.Validate.canBuyLotto;
import static lotto.Validate.isInteger;

public class LottoTicket {

    public List<Lotto> buy(String input) {
        List<Lotto> lottos = new ArrayList<>();
        int money = isInteger(input);
        canBuyLotto(money);

        for (int ticket = 0; ticket < money / 1000; ticket++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }
}
