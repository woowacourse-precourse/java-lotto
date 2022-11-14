package lotto;

import java.util.ArrayList;
import java.util.List;

public class BuyingLotto {
    final int count;
    List<List<Integer>> lottos = new ArrayList<>();

    BuyingLotto() {
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
