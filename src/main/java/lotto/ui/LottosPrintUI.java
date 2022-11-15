package lotto.ui;

import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottosPrintUI {
    private String format = "%d개를 구매했습니다.";

    public void print(List<Lotto> lottos) {
        System.out.println(String.format(format, lottos.size()));
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
        System.out.println();
    }

    private void printLotto(Lotto lotto) {
        Collections.sort(lotto.getNumbers());
        System.out.print("[");
        System.out.print(String.join(", ",
                lotto.getNumbers().stream().map(String::valueOf).collect(Collectors.toList())));
        System.out.println("]");
    }

}
