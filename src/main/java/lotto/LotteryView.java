package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LotteryView {
    public LotteryView() {}

    public String getUserMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String getUserNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String getUserBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public void printPurchasedLotto(List<Lotto> lottoList) {
        int count = lottoList.size();
        System.out.printf("%d개를 구매했습니다.\n", count);
        for (Lotto lotto: lottoList) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers.toString());
        }
    }

    public void printStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
