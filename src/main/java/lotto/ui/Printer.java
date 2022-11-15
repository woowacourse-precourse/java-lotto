package lotto.ui;

import lotto.Lotto;
import lotto.domain.Rank;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Printer {

    public void printLotto(int amount, List<Lotto> myLotto) {
        System.out.println(amount + Message.BUY_LOTTO);
        for (Lotto one : myLotto) {
            Collections.sort(one.getNumbers());
            System.out.println(one.getNumbers());
        }
    }

    public void printWinning(Map<String, Integer> lottoStatus) {
        System.out.println(Message.OUTPUT_WINNING);
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            String ouputMessage = rank.ouputMessage();
            int count = lottoStatus.get(rank.name());
            System.out.printf("%s - %d개", ouputMessage, count);
            System.out.println();
        }
    }
}