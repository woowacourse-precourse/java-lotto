package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해 주세요.");
        User user = new User();
        int amount = user.purchaseAmount();
        System.out.println();
        int count = 0, totalWinningAmount = 0;
        List<Lotto> lottoList = new ArrayList<Lotto>();

        List<Integer> winningNumber = new ArrayList<Integer>();

        int bonusNumber = 0;

        try {
            amountValidation(amount);

            WinningHistory winningHistory = new WinningHistory();

            Lotto[] lottos = new Lotto[amount / 1000];
            lotteryNumberOutput(amount, lottoList, lottos);

            winningNumber = getWinningNumber(user);

            bonusNumber = getBonusNumber(user, winningNumber);

            System.out.println("당첨 통계");
            System.out.println("---");
            for (Lotto lotto : lottoList) {
                for (int i = 0; i < lotto.getNumbers().size(); i++) {
                    if (winningNumber.contains(lotto.getNumbers().get(i))) {
                        count += 1;
                    }
                }

                if (count == 6) {
                    totalWinningAmount += Winnings.이십억.winnings();
                    winningHistory.setRank1Number(winningHistory.getRank1Number() + 1);
                    continue;
                }

                if (count == 5 && lotto.getNumbers().contains(bonusNumber)) {
                    totalWinningAmount += Winnings.삼천만.winnings();
                    winningHistory.setRank2Number(winningHistory.getRank2Number() + 1);
                    continue;
                }

                if (count == 5) {
                    totalWinningAmount += Winnings.삼천만.winnings();
                    winningHistory.setRank2Number(winningHistory.getRank3Number() + 1);
                    continue;
                }

                if (count == 4) {
                    totalWinningAmount += Winnings.오만.winnings();
                    winningHistory.setRank4Number(winningHistory.getRank4Number() + 1);
                    continue;
                }

                if (count == 3) {
                    totalWinningAmount += Winnings.오천.winnings();
                    winningHistory.setRank5Number(winningHistory.getRank5Number() + 1);
                    continue;
                }

                count = 0;
            }

            System.out.println("3개 일치 (5,000원) - " + winningHistory.getRank5Number() + "개");
            System.out.println("4개 일치 (50,000원) - " + winningHistory.getRank4Number() + "개");
            System.out.println("5개 일치 (1,500,000원) - " + winningHistory.getRank3Number() + "개");
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningHistory.getRank2Number() + "개");
            System.out.println("6개 일치 (2,000,000,000원) - " + winningHistory.getRank1Number() + "개");

            double yield = (double) totalWinningAmount / (double) amount * 100;
            System.out.println("총 수익률은 " + Math.round(yield * 10) / 10.0 + "%입니다.");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void lotteryNumberOutput(int amount, List<Lotto> lottoList, Lotto[] lottos) {
        System.out.println(amount / 1000 + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoList.add(lotto);
            System.out.println(lotto.getNumbers());
        }

        System.out.println();
    }

    private static int getBonusNumber(User user, List<Integer> winningNumber) {

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = user.enterBonusNumber(winningNumber);
        System.out.println();

        return bonusNumber;
    }

    private static List<Integer> getWinningNumber(User user) {
        List<Integer> winningNumber;
        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumber = user.enterWinningNumber();
        System.out.println();
        return winningNumber;
    }

    private static void amountValidation(int amount) {

        if (amount % 1000 != 0 || amount == -1) {
            throw new IllegalArgumentException("[ERROR] 천 원단위로 입력해 주세요.");
        }
    }
}
