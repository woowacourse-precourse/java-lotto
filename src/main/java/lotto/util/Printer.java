package lotto.util;

import lotto.domain.Lotto;

import java.util.List;

public class Printer {
    public void print(String message) {
        System.out.println(message);
    }

    public void divide() {
        System.out.println();
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
