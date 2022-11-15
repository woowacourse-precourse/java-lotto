package lotto.view;

import java.util.List;

public class Output {

    public static void statistics(List<Integer> count, String rate) {

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + count.get(5) + "개");
        System.out.println("4개 일치 (50,000원) - " + count.get(4)+ "개");
        System.out.println("5개 일치 (1,500,000원) - " + count.get(3)+ "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count.get(2)+ "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + count.get(1)+ "개");

        System.out.println("총 수익률은 " + rate+ "%입니다.");
    }
}
