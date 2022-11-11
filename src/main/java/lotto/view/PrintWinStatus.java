package lotto.view;

import lotto.domain.PrizePolicy;

import java.util.List;
import java.util.Objects;


/**
 * 당첨 통계
 * ---
 * 3개 일치 (5,000원) - 1개
 * 4개 일치 (50,000원) - 0개
 * 5개 일치 (1,500,000원) - 0개
 * 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
 * 6개 일치 (2,000,000,000원) - 0개
 */
public class PrintWinStatus {

    PrizePolicy policy = new PrizePolicy();

    public void printMatchBoard() {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (int i = 0; i < policy.match.size(); i++) {
            System.out.println(policy.match.get(i) + "개 일치 " +
                    "(" + policy.prize.get(i) + "원) - " + policy.count.get(i) + "개");
        }
    }

    public void countStatus(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            countMatching(list, i);
        }
    }

    private void countMatching(List<Integer> list, int i) {
        for (int j = 0; j < policy.match.size(); j++) {

            if (Objects.equals(list.get(i), policy.match.get(j))) {

                policy.increaseCount(j);
            }
        }
    }
}
