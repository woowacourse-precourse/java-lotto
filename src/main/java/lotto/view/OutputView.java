package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Messages;

import java.util.List;

public class OutputView {
    public static void printLottoList(List<Lotto> lottoList) {
        System.out.printf(Messages.OUTPUT_LOTTO_COUNT.get(), lottoList.size());
        for (Lotto lotto : lottoList)
            System.out.println(lotto.getNumbers());
        System.out.printf("\n");
    }
}
