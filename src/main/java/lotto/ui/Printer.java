package lotto.ui;

import lotto.Lotto;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Printer {

    public void printLotto(int amount, List<Lotto> myLotto) {
        System.out.println(amount + Message.BUY_LOTTO);
        for (Lotto one : myLotto) {
            List<Integer> sorting = new ArrayList<>(one.getNumbers());
            Collections.sort(sorting);
            System.out.println(sorting);
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

    public void printRevenue(float percent) {
        System.out.printf("총 수익률은 %.1f%%입니다.", percent);
    }
}