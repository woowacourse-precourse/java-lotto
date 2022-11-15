package view;

import lotto.Lotto;
import service.LottoUserService;

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
        LottoUserService lottoService = new LottoUserService();
        List<List<Integer>> userRandomNumbers = new ArrayList<>();

        userRandomNumbers = lottoService.saveUserRandomNumbers(count, userRandomNumbers);
        for (int i = 0; i < count; i++) {
            System.out.println(userRandomNumbers.get(i));
        }

        return userRandomNumbers;
    }

    // 당첨 내역 출력
    public void printWinningResult(List<List<Integer>> userRandomNumber, int count, Lotto lotto) {
        int[] matches = {0, 0, 0, 0};
        String[] moneys = {"5,000", "50,000", "1,500,000", "2,000,000,000"};

        matches = lotto.countWinningResult(userRandomNumber, count, matches);

        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 0; i < matches.length; i++) {
            System.out.println((i + 3) + "개 일치 (" + moneys[i] + "원) - " + matches[i] + "개");
        }
    }
}
