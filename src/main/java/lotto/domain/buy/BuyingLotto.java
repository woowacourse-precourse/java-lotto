package lotto.domain.buy;

import lotto.domain.buy.domain.Customer;
import lotto.domain.buy.domain.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class BuyingLotto {
    final int count;
    public List<List<Integer>> lottos = new ArrayList<>();

    public BuyingLotto() {
        System.out.println("구매금액을 입력해 주세요.");
        count = new Customer().count;
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new LottoGenerator().numbers;
            lottos.add(numbers);
        }
        for (int i = 0; i < count; i++) {
            System.out.println(lottos.get(i));
        }
    }
}
