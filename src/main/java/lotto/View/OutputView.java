package lotto.View;

import lotto.Prize;
import lotto.WinningStat;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class OutputView {
    private final DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public void printList(List<String> list) {
        System.out.println(list.size() + "개를 구매했습니다.");
        list.forEach(System.out::println);
    }

    public void printStats(WinningStat winningStat) {
        Arrays.stream(Prize.values())
                .filter(x -> x != Prize.NONE)
                .forEach(x -> printStat(x, winningStat.getNumber(x)));
    }

    private void printStat(Prize prize, int number) {
        System.out.print(prize.getNumber() + "개 일치");
        if (prize == Prize.SECOND) {
            System.out.print(", 보너스 볼 일치");
        }
        System.out.println(" (" + decimalFormat.format(prize.getPrize()) + "원) - " + number + "개");
    }

    public void printYield(String yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
