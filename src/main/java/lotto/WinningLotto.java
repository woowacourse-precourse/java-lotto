package lotto;

import java.util.List;

public class WinningLotto {
    private final String threeWins = "3개 일치 (5,000원) - ";
    private final String fourWins = "4개 일치 (50,000원) - ";
    private final String fiveWins = "5개 일치 (1,500,000원) - ";
    private final String fiveWinsIncludBonus = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private final String sixWins = "6개 일치 (2,000,000,000원) - ";

    public WinningLotto(List<Integer> number, List<List<Integer>> numbers) {
        checkWinningLotto(number,numbers);
    }

    private void checkWinningLotto(List<Integer> number, List<List<Integer>> numbers) {
        for (List<Integer> num : numbers) {
            countWinningLotto(number, num);
        }
    }

    private void countWinningLotto(List<Integer> number, List<Integer> num) {
        int cnt;
        int threeWinsNum = 0;
        int fourWinsNum = 0;
        int fiveWinsNum = 0;
        int fiveWinsIncludBonusNum = 0;
        int sixWinsNum = 0;
        cnt = countOverlapNumber(number, num);
        if (!num.contains(number.get(6)) && cnt == 3) {
            threeWinsNum++;
            System.out.println(this.threeWins + threeWinsNum + "개");
        }
        if (!num.contains(number.get(6)) && cnt == 4) {
            fourWinsNum++;
            System.out.println(this.fourWins + fourWinsNum + "개");
        }
        if (!num.contains(number.get(6)) && cnt == 5) {
            fiveWinsNum++;
            System.out.println(this.fiveWins + fiveWinsNum + "개");
        }
        if (cnt == 5) {
            fiveWinsIncludBonusNum++;
            System.out.println(this.fiveWinsIncludBonus + fiveWinsIncludBonusNum + "개");
        }
        if (!num.contains(number.get(6)) && cnt == 6) {
            sixWinsNum++;
            System.out.println(this.sixWins + sixWinsNum + "개");
        }
    }

    private static int countOverlapNumber(List<Integer> number, List<Integer> num) {
        int cnt = 0;
        for (int numberr : number) {
            if (num.contains(numberr)) {
                cnt++;
            }
        }
        return cnt;
    }
}