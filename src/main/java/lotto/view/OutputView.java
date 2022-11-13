package lotto.view;

import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLottoList(Lotties lotties) {
        System.out.println(lotties.getLottiesSize());

        for (Lotto lotto : lotties.getLotties()) {
            List<Integer> collect = lotto.getNumbers()
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());

            System.out.println(collect);
        }
    }
}
