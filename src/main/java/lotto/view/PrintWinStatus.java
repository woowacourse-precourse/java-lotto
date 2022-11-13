package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Policy;
import lotto.service.NumberMatcher;

import java.util.List;


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

    NumberMatcher numberMatcher = new NumberMatcher();
    Policy policy = new Policy();

    private static void adjust() {
        Integer fiveMatchCount = Policy.count.get(2);
        Policy.count.add(2, fiveMatchCount - 1);

        Integer sixMatchCount = Policy.count.get(3);
        Policy.count.add(3, sixMatchCount - 1);
    }

    public static void increaseCount(int index) {
        Integer num = Policy.count.get(index);
        num++;
        Policy.count.add(index, num);
        System.out.println(Policy.count.get(index));
    }

    public void scoreBoard() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) -" + Policy.count.get(0) + "개");
        System.out.println("4개 일치 (50,000원원) -" + Policy.count.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원원) -" + Policy.count.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) -" + policy.bonusCount + "개");
        System.out.println("6개 일치 (2,000,000,000원) -" + Policy.count.get(3) + "개");
    }

    public void bonusCase(List<Lotto> allLotto, List<Integer> winningNums, int bonusNum) {

        for (Lotto lotto : allLotto) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int num = numberMatcher.countSameNumber(lottoNumbers, winningNums);
            if (num == 5 && lottoNumbers.contains(bonusNum)) {

                policy.increaseBonusCount();

                adjust();
            }
        }
    }

    public void countStatus(List<Integer> sameNumberCount) {
        initCount();
        for (int i = 0; i < sameNumberCount.size(); i++) {
            compare(sameNumberCount, i);
        }
    }

    private void compare(List<Integer> sameNumberList, int i) {
        for (int j = 0; j < Policy.match.size(); j++) {

            if (sameNumberList.get(i) == Policy.match.get(j)) {

                increaseCount(j);
            }
        }
    }

    private void initCount() {
        for (int i = 0; i < 4; i++) {
            Policy.count.add(0);
        }
    }
}
