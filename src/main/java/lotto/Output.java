package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Output {

    public static void giveMeMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void giveMeWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void giveMeBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void lottoQuantity(int money) {
        System.out.println(Store.countLines(money) + "개를 구매했습니다.");
    }

    public static void lotteriesNumbers(List<Lotto> lotteries) {
        List<Integer> sortNumbers = new ArrayList<>();
        for (Lotto item : lotteries) {
            sortNumbers = sortNumbers(item.getNumbers());
            System.out.println(sortNumbers);
        }
    }

    public static List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>();
        for (Integer item : numbers) {
            sortedNumbers.add(item);
        }
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public static void winningHistory(Judge judge) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + judge.rankCount.get(5) + "개");
        System.out.println("4개 일치 (50,000원) - " + judge.rankCount.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + judge.rankCount.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + judge.rankCount.get(2) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + judge.rankCount.get(1) + "개");
    }

    public static void earningRate(Judge judge, int money) {
        System.out.println("총 수익률은 " + judge.countEarningsRate(money) + "%입니다.");
    }

}
