package lotto;

import java.util.List;

enum Winning {
    FIRST(2_000_000_000, 0),
    SECOND(30_000_000, 0),
    THIRD(1_500_000, 0),
    FOURTH(50_000, 0),
    FIFTH(5_000, 0);

    public int prize;
    public int cnt;

    Winning(int prize, int cnt) {
        this.prize = prize;
        this.cnt = cnt;
    }

    public int multiple() {
        return cnt * prize;
    }
}

public class Result {
    public static void compareLottoNumber(List<Lotto> myLotto,
                                          List<Integer> winningNumber,
                                          int bonusNumber,
                                          int purchaseMoney) {
        for (Lotto lotto : myLotto) {
            int winning = countWinningNumber(lotto, winningNumber);
            boolean bonus = containBonusNumber(lotto, bonusNumber);
            checkTheResult(winning, bonus);
        }

        printTheResult();
        calculateTheProfit(purchaseMoney);
    }

    public static int countWinningNumber(Lotto lotto, List<Integer> winningNumber) {
        int cnt = 0;
        for (int number : winningNumber) {
            cnt += containWinningNumber(lotto, number);
        }

        return cnt;
    }

    public static boolean containBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.containNumber(bonusNumber);
    }

    public static int containWinningNumber(Lotto lotto, int winningNumber) {
        if (lotto.containNumber(winningNumber)) {
            return 1;
        }
        return 0;
    }

    public static void checkTheResult(int winning, boolean bonus) {
        if (winning == 6) {
            Winning.FIRST.cnt++;
        }
        if (winning == 5 && bonus == true) {
            Winning.SECOND.cnt++;
        }
        if (winning == 5 && bonus == false) {
            Winning.THIRD.cnt++;
        }
        if (winning == 4) {
            Winning.FOURTH.cnt++;
        }
        if (winning == 3) {
            Winning.FIFTH.cnt++;
        }
    }

    public static void printTheResult() {
        System.out.println("3개 일치 (5,000원) -  " + Winning.FIFTH.cnt + "개");
        System.out.println("4개 일치 (50,000원) -  " + Winning.FOURTH.cnt + "개");
        System.out.println("5개 일치 (1,500,000원) -  " + Winning.THIRD.cnt + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) -  " + Winning.SECOND.cnt + "개");
        System.out.println("6개 일치 (2,000,000,000원) -  " + Winning.FIRST.cnt + "개");
    }

    public static void calculateTheProfit(int purchaseMoney) {
        double prize = 0;

        for (Winning winning : Winning.values()) {
            prize += winning.multiple();
        }

        double profit = prize * 100 / purchaseMoney;

        printTheProfit(profit);
    }

    public static void printTheProfit(double profit) {
        System.out.println("총 수익률은 " + String.format(" %.1f", profit) + "%입니다.");
    }

}

