package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Stats;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lotto.domain.Stats.*;

public class OutputView {
    private static final String PURCHASE = "개를 구매했습니다.";
    public static final String ACCORD_NUMBER_FORMAT = "개 일치";
    public static final String ACCORD_NUMBER_AND_BONUS_FORMAT = ", 보너스 볼 일치 ";
    public static final String AMOUNT_MARK_REGEX = "\\B(?=(\\d{3})+(?!\\d))";
    public static final String HYPHEN = " - ";
    public static final String NUMBER_UNIT = "개";
    private static final String START_PARENTHESES = "(";
    private static final String END_PARENTHESES = ")";
    private static final String SPACE = " ";
    private static final String PROFIT = "총 수익률은 %d%입니다.";

    private OutputView() {
    }

    public static void printPurchase(int count, List<Lotto> lottos) {
        System.out.println(count + PURCHASE);
        lottos.forEach(lotto -> {
            Collections.sort(lotto.getNumbers());
            System.out.println(lotto.getNumbers());
        });
    }

    public static void printStats() {
        Arrays.stream(values())
                .filter(element -> !element.equals(CONTINUE))
                .forEach(element -> {
                    System.out.print(Stats.getName(element) + SPACE);
                    System.out.print(START_PARENTHESES + Stats.getAmount(element) + END_PARENTHESES);
                    System.out.println(Stats.getCount(element));
                });
    }
}
