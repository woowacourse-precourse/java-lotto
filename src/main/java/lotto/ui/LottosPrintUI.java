package lotto.ui;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottosPrintUI {
    private static final String FORMAT = "%d개를 구매했습니다.";

    public void print(List<Lotto> lottos) {
        System.out.println(String.format(FORMAT, lottos.size()));
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
        System.out.println();
    }

    private void printLotto(Lotto lotto) {
        List<Integer> orderModifiableLottos = new ArrayList<>(lotto.getNumbers());
        Collections.sort(orderModifiableLottos);
        System.out.print("[");
        System.out.print(String.join(", ",
                orderModifiableLottos.stream().map(String::valueOf).collect(Collectors.toList())));
        System.out.println("]");
    }

}
