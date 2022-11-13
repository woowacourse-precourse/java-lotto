package lotto.view;

import java.util.List;

import lotto.Lotto;

public class OutputView {

    public static void printBuyHistory(List<Lotto> lottos) {
        int amount = lottos.size();
        System.out.println(String.format("%d개를 구매했습니다.", amount));
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

}