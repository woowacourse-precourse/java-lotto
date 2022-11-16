package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintWinnerStatisticsGenerator {
    public static void printWinner(List<Integer> resultNumber) {
        List<Integer> winnerStatistics = new ArrayList<>();
        System.out.println("당첨통계");
        System.out.println("---");

        for(int i=0; i<8; i++) {
            winnerStatistics.add(Collections.frequency(resultNumber, i)); // i가 resultNumber에 몇번 있었는지 저장
        }

        System.out.printf("3개 일치 (5,000원) - %d개\n", winnerStatistics.get(3));
        System.out.printf("4개 일치 (50,000원) - %d개\n", winnerStatistics.get(4));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", winnerStatistics.get(5));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", winnerStatistics.get(6));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", winnerStatistics.get(7));
    }
}
