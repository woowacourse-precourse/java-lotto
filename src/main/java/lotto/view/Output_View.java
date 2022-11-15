package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class Output_View {
    public void print_LottoCnt(int lottoCnt) {
        System.out.println(lottoCnt + "개를 구매했습니다.");
    }

    public static void print_RandomLottoNumbers(List<Lotto> allLottoNumber) {
        for (Lotto eachLotto : allLottoNumber) {
            System.out.println(eachLotto.getNumbers().toString());
        }
    }

    public static void print_winningStats(int[] win_stats) {
        System.out.printf("3개 일치 (5,000원) - %d개\n", win_stats[0]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", win_stats[1]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", win_stats[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", win_stats[3]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", win_stats[4]);
    }

    public static void print_yield(String yield) {
        System.out.printf("총 수익률은 %s입니다.", yield);
    }

}