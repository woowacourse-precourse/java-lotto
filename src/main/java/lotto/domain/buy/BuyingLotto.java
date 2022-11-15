package lotto.domain.buy;

import lotto.domain.buy.domain.Customer;
import lotto.domain.buy.domain.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.PrintMessage.BOUGHT;
import static lotto.constant.PrintMessage.ENTER_MONEY;

public class BuyingLotto {
    final int count;
    public List<List<Integer>> lottos = new ArrayList<>();

    public BuyingLotto() {
        System.out.println(ENTER_MONEY);
        count = new Customer().count;
        System.out.println(count + BOUGHT);
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new LottoGenerator().numbers;
            lottos.add(numbers);
        }
        for (int i = 0; i < count; i++) {
            System.out.println(lottos.get(i));
        }
    }
}
