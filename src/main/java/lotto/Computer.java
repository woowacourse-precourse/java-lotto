package lotto;


import java.util.HashMap;
import java.util.List;

public class Computer {
    private final HashMap<String, Integer> winningInfo = new HashMap<>();

    public Computer() {
        winningInfo.put("FIFTH", 0);
        winningInfo.put("FOURTH", 0);
        winningInfo.put("THIRD", 0);
        winningInfo.put("SECOND", 0);
        winningInfo.put("FIRST", 0);
    }

    public void computeWinnings(LottoMachine lottoMachine) {
        List<Lotto> issuedLotto = lottoMachine.getIssuedLotto();
        Lotto winningLotto = lottoMachine.getWinningLotto();
        int bonus = lottoMachine.getBonus();

        for (Lotto issued : issuedLotto) {
            int winning = countWinning(issued, winningLotto);
            boolean bonusFlag = checkBonusInWinning(bonus, winningLotto);

            String winningString = generateWinning(winning, bonusFlag);
            if (!winningString.equals("")) {
                int currentCount = this.winningInfo.get(winningString);
                this.winningInfo.put(winningString, currentCount+1);
            }
        }
    }

    private static int countWinning(Lotto issuedLotto, Lotto winningLotto) {
        int count = 0;
        for (int issuedNumber : issuedLotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(issuedNumber)) {
                count++;
            }
        }
        return count;
    }

    private static boolean checkBonusInWinning(int bonus, Lotto winningLotto) {
        return winningLotto.getNumbers().contains(bonus);
    }

    private static String generateWinning(int winningCount, boolean bonusFlag) {
        if (winningCount == 3) {
            return "FIFTH";
        }
        if (winningCount == 4) {
            return "FOURTH";
        }
        if (winningCount == 5 && !bonusFlag) {
            return "THIRD";
        }
        if (winningCount == 5) {
            return "SECOND";
        }
        if (winningCount == 6) {
            return "FIRST";
        }
        return "";
    }

    public void printWinnings() {
        System.out.println("3개 일치 (5,000원) - " + winningInfo.get("FIFTH") + "개");
        System.out.println("4개 일치 (50,000원) - " + winningInfo.get("FOURTH") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningInfo.get("THIRD") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningInfo.get("SECOND") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningInfo.get("FIRST") + "개");
    }

    public void printYield(User user) {
        float profit;
        int money = user.getMoney();
        profit = winningInfo.get("FIFTH") * LottoRanking.FIFTH.prize();
        profit += winningInfo.get("FOURTH") * LottoRanking.FOURTH.prize();
        profit += winningInfo.get("THIRD") * LottoRanking.THIRD.prize();
        profit += winningInfo.get("SECOND") * LottoRanking.SECOND.prize();
        profit += winningInfo.get("FIRST") * LottoRanking.FIRST.prize();
        System.out.println("총 수익률은 " + (profit / money) * 100 + "%입니다.");
    }


}
