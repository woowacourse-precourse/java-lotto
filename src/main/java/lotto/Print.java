package lotto;

import java.util.List;

public class Print {
    public void printNumbers(List<List<Integer>> lottoTickets) {
        System.out.println(lottoTickets.size()+"개를 구매했습니다.");
        for (List<Integer> ticket : lottoTickets) {
            System.out.println(ticket);
        }
    }

    public void printWinningStatistics(int[] result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+result[0]+"개");
        System.out.println("4개 일치 (50,000원) - "+result[1]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+result[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+result[4]+"개");
        System.out.print("6개 일치 (2,000,000,000원) - "+result[3]+"개");
    }

    public void printProfit(int[] result, int money) {
        int sum = 0;
        sum += result[3] * 2000000000;
        sum += result[4] * 30000000;
        sum += result[2] * 1500000;
        sum += result[1] * 50000;
        sum += result[0] * 5000;
        double profit = sum / (double) (money) * 100;
        String information = String.format("%n총 수익률은 %.1f%%입니다.", profit);
        System.out.println(information);
    }


}
