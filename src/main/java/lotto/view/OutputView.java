package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Stats;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lotto.constance.OutputViewConstance.*;
import static lotto.domain.Stats.*;

public class OutputView {
    private OutputView() {
    }

    public static void printPurchase(int count, List<Lotto> lottos) {
        System.out.println();
        System.out.println(count + PURCHASE);
        lottos.forEach(lotto -> {
            Collections.sort(lotto.getNumbers());
            System.out.println(lotto.getNumbers());
        });
        System.out.println();
    }

    public static void printStats() {
        Arrays.stream(values())
                .filter(element -> !element.equals(CONTINUE))
                .forEach(element -> {
                    System.out.print(Stats.getName(element) + SPACE);
                    System.out.print(START_PARENTHESES + Stats.getAmount(element) + AMOUNT_FORMAT + END_PARENTHESES);
                    System.out.println(Stats.getCount(element));
                });
    }

    public static void printProfit(double profit) {
        System.out.println(START_PROFIT + Math.round(profit * 10) / 10.0 + END_PROFIT);
    }
}
