package view;

import lotto.Lotto;
import service.LottoService;

import java.util.ArrayList;
import java.util.List;

public class OutputUI {
    // 구매한 복권 수 출력
    public int printPurchaseAmountResult(int amount) {
        int count = amount / 1000;
        System.out.println(count + "개를 구매했습니다.");

        return count;
    }

    // 사용자 랜덤 숫자 출력
    public List<List<Integer>> printUserRandomNumbers(int count) {
        LottoService lottoService = new LottoService();
        List<List<Integer>> userRandomNumbers = new ArrayList<>();

        userRandomNumbers = lottoService.saveUserRandomNumbers(count, userRandomNumbers);
        for (int i = 0; i < count; i++) {
            System.out.println(userRandomNumbers.get(i));
        }

        return userRandomNumbers;
    }

    // 당첨 내역 출력
    public void printWinningResult(List<List<Integer>> userRandomNumber, int count, Lotto lotto, int bonusNumber, int amount) {
        int[] matches = {0, 0, 0, 0, 0};
        String bonusMoney = "30,000,000";
        String[] moneys = {"5,000", "50,000", "1,500,000", bonusMoney, "2,000,000,000"};

        matches = lotto.countWinningResult(userRandomNumber, count, matches, bonusNumber);

        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 0; i < matches.length; i++) {
            printTheNumberOfCases(i, matches, moneys, bonusMoney);
        }

        System.out.println("총 수익률은 " + returnIncomeRate(matches, amount) + "%입니다.");
    }

    public void printTheNumberOfCases(int index, int[] matches, String[] moneys, String bonusMoney) {
        if (index == 3) {
            System.out.println("5개 일치, 보너스 볼 일치 (" + bonusMoney + "원) - " + matches[index] + "개");
            return;
        }

        if (index == 4) {
            System.out.println((index + 2) + "개 일치 (" + moneys[index] + "원) - " + matches[index] + "개");
            return;
        }

        System.out.println((index + 3) + "개 일치 (" + moneys[index] + "원) - " + matches[index] + "개");
    }

    public double returnIncomeRate(int[] matches, int amount) {
        // 총 수익  내가 낸 돈 * 100
        String[] moneys = {"5000", "50000", "1500000", "30000000", "2000000000"};
        double sum = 0;

        for (int i = 0; i < matches.length; i++) {
            sum += (Integer.parseInt(moneys[i]) * matches[i]);
        }

        return (sum / amount) * 100;
    }
}
