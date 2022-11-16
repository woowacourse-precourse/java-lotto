package lotto;

import java.util.List;

enum Winning {
    FIRST(2_000_000_000, 0, "6개 일치 (2,000,000,000원) - "),
    SECOND(30_000_000, 0, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(1_500_000, 0, "5개 일치 (1,500,000원) - "),
    FOURTH(50_000, 0, "4개 일치 (50,000원) - "),
    FIFTH(5_000, 0, "3개 일치 (5,000원) - ");

    public int prize;
    public int cnt;
    public String message;

    Winning(int prize, int cnt, String message) {
        this.prize = prize;
        this.cnt = cnt;
        this.message = message;
    }

    public int multiple() {
        return cnt * prize;
    }
}

public class Result {
    public static void compareLottoNumber(List<Lotto> myLotto, Lotto winningNumber, int bonusNumber, int purchaseMoney) throws IllegalArgumentException {
        for (Lotto lotto : myLotto) {
            int winning = countWinningNumber(lotto, winningNumber);
            boolean bonus = containBonusNumber(lotto, bonusNumber);
            checkTheResult(winning, bonus);
        }

        printTheResult();
        calculateTheProfit(purchaseMoney);
    }

    public static int countWinningNumber(Lotto lotto, Lotto winningNumber) {
        int cnt = 0;

        for (int number : winningNumber.getNumbers()) {
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
        for(Winning winning : Winning.values()) {
            System.out.println(winning.message + winning.cnt + "개");
        }
    }

    public static void calculateTheProfit(int purchaseMoney) {
        double profit = totalPrize() * 100 / purchaseMoney;

        printTheProfit(profit);
    }

    public static double totalPrize() {
        double result = 0;

        for (Winning winning : Winning.values()) {
            result += winning.multiple();
        }

        return result;
    }

    public static void printTheProfit(double profit) {
        System.out.println("총 수익률은 " + String.format("%.1f", profit) + "%입니다.");
    }

}

