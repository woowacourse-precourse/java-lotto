package lotto.domain.seller;

import java.util.List;

public interface Seller {

    int findLottoCountByMoney(int money);

    int compareNumbers(List<Integer> numbers);
}
