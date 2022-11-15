package lotto.ui;

import lotto.domain.WinningResult;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ResultPrintUI {
    private static final String TITLE = "당첨 통계";
    private static final String LINE = "---";
    private static final String BODY = "%d개 일치%s (%s원) - %d개";
    private static final String BONUS = ", 보너스 볼 일치";
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###");

    public void print(Map<WinningResult, Integer> results) {
        System.out.println(TITLE);
        System.out.println(LINE);
        for (WinningResult result : printOrder(WinningResult.values())) {
            if (result == WinningResult.NONE) {
                continue;
            }
            System.out.println(printFormat(result, results.getOrDefault(result, 0)));
        }
    }

    private List<WinningResult> printOrder(WinningResult[] defaultOrder) {
        List<WinningResult> reverseOrder = Arrays.asList(defaultOrder);
        Collections.reverse(reverseOrder);
        return reverseOrder;
    }

    private String printFormat(WinningResult result, int count) {
        String isBonus = "";
        if (result.getBonus() == 1) {
            isBonus = BONUS;
        }
        return String.format(BODY, result.getWinning(), isBonus, DECIMAL_FORMAT.format(result.getPrize()), count);
    }

}
