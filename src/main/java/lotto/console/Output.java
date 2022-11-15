package lotto.console;

import java.util.List;
import lotto.ticket.Lotto;

public class Output {

    public static void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
}
