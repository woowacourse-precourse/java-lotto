package lotto;


import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        User user = new User();
        LottoMachine lottoMachine = new LottoMachine();


        user.inputMoney();
        int money = user.getMoney();
        lottoMachine.inputWinningLotto();
        Lotto winningLotto = lottoMachine.getWinningLotto();
        lottoMachine.inputBonusNumber();
        int bonus = lottoMachine.getBonus();

        lottoMachine.issueLotto(user.getMoney());
        List<Integer> winningInfo;

        List<Lotto> issuedLotto = lottoMachine.getIssuedLotto();
        printIssuedLotto(issuedLotto);

        winningInfo = checkWinnings(issuedLotto, winningLotto, bonus);
        printWinnings(winningInfo);
        printYield(winningInfo, money);

    }


    public static void printIssuedLotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            lotto.printLotto();
        }
    }

    public static void printWinnings(List<Integer> winningInfo) {
        System.out.println("3개 일치 (5,000원) - " + winningInfo.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + winningInfo.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningInfo.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningInfo.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningInfo.get(4) + "개");

    }

    public static List<Integer> checkWinnings(List<Lotto> issuedLotto, Lotto lotto, int bonus) {
        List<Integer> winningInfo = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            winningInfo.add(0);
        }
        for (Lotto currentLotto : issuedLotto) {
            int winningIndex;
            winningIndex = computeWinningIndex(currentLotto, lotto, bonus);
            if (winningIndex != -1) {
                int currentCount = winningInfo.get(winningIndex);
                winningInfo.set(winningIndex, currentCount + 1);
            }
        }


        return winningInfo;
    }

    private static int computeWinningIndex(Lotto currentLotto, Lotto lotto, int bonus) {

        int winningCount = 0;
        boolean bonusFlag = false;
        for (int lottoNumber : currentLotto.getNumbers()) {
            if (lotto.getNumbers().contains(lottoNumber)) {
                winningCount++;
            }
            if (lottoNumber == bonus) {
                bonusFlag = true;
            }
        }
        return generateWinningCount(winningCount, bonusFlag);
    }

    public static int generateWinningCount(int winningCount, boolean bonusFlag) {
        if (winningCount == 3) {
            return 0;
        }
        if (winningCount == 4) {
            return 1;
        }
        if (winningCount == 5 && !bonusFlag) {
            return 2;
        }
        if (winningCount == 5) {
            return 3;
        }
        if (winningCount == 6) {
            return 4;
        }
        return -1;
    }

    public static void printYield(List<Integer> winningInfo, int money) {
        float profit;
        profit = winningInfo.get(0) * 5000;
        profit += winningInfo.get(1) * 50000;
        profit += winningInfo.get(2) * 1500000;
        profit += winningInfo.get(3) * 30000000;
        profit += winningInfo.get(4) * 2000000000;
        System.out.println("총 수익률은 " + (profit / money) * 100 + "%입니다.");
    }

}
