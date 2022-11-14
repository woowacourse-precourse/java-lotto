package lotto.ui;

import lotto.Lotto;

import java.util.Collections;
import java.util.List;

public class Printer {

    public void printLotto(int amount, List<Lotto> myLotto) {
        System.out.println(amount + Message.BUY_LOTTO);
        for (Lotto one : myLotto) {
            Collections.sort(one.getNumbers());
            System.out.println(one.getNumbers());
        }
    }
}