package lotto.console;

import lotto.domain.Rank;

import java.util.List;

/***
 * 출력 클래스
 */
public class OutputConsole {
    public void lottoCount(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }

    public void randomNumbers(List<List<Integer>> numbers) {
        for (List<Integer> number : numbers) {
            System.out.println(number);
        }
    }

    public void lottoRank(List<Integer> lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 0; i < lottoResult.size(); i++) {
            Rank rank = Rank.valueOf(i);
            System.out.printf("%s - %d개\n", rank.getMessage(), lottoResult.get(i));
        }
    }

}
