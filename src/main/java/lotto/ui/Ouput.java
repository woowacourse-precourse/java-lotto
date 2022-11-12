package lotto.ui;

import java.util.Collections;
import java.util.List;

import lotto.domain.Lotto;

public class Ouput {
    public void notifyPurchasedLottoTable(List<Lotto> lottoTable) {
        System.out.printf("%d개를 구매했습니다.\n", lottoTable.size());
        for (int i = 0; i < lottoTable.size(); i++) {
            List<Integer> numbers = lottoTable.get(i).getNumbers();
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

}
