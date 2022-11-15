package lotto.ui;

import lotto.domain.WinningResult;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ResultPrintUI {
    private static final String title = "당첨통계";
    private static final String line = "---";
    private static final String body = "%d개 일치%s (%s원) - %d개";
    private static final String bonus = ", 보너스 볼 일치";
    private static final DecimalFormat decFormat = new DecimalFormat("###,###");

    public void print(Map<WinningResult, Integer> results) {
        System.out.println(title);
        System.out.println(line);
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
            isBonus = bonus;
        }
        return String.format(body, result.getWinning(), isBonus, decFormat.format(result.getPrize()), count);
    }

}
