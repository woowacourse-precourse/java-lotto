package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static List<Lotto> lottoList = new ArrayList<Lotto>();
    static List<Integer> winningNumber = new ArrayList<Integer>();
    static int count = 0, totalWinningAmount = 0;
    static int bonusNumber = 0;

    public static void main(String[] args) {

        User user = getUser();
        int amount = getAmount(user.purchaseAmount());

        try {

            play(user, amount);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void play(User user, int amount) {
        amountValidation(amount);

        WinningHistory winningHistory = new WinningHistory();

        Lotto[] lottos = new Lotto[amount / 1000];
        lotteryNumberOutput(amount, lottoList, lottos);

        int[][] graph = new int[lottoList.size()][5]; //당첨 내역 출력을 위한 그래프

        winningNumber = getWinningNumber(user);

        bonusNumber = getBonusNumber(user, winningNumber);

        winningHistoryOutput((double) amount, count, totalWinningAmount, lottoList, winningNumber, bonusNumber, winningHistory);
    }

    private static int getAmount(int user) {
        int amount = user;
        System.out.println();
        return amount;
    }

    private static User getUser() {
        System.out.println("구입금액을 입력해 주세요.");
        User user = new User();
        return user;
    }

    private static void winningHistoryOutput(double amount, int count, int totalWinningAmount, List<Lotto> lottoList,
                                             List<Integer> winningNumber, int bonusNumber, WinningHistory winningHistory) {

        System.out.println("당첨 통계");
        System.out.println("---");
        totalWinningAmount = getTotalWinningAmount(count, totalWinningAmount, lottoList, winningNumber, bonusNumber, winningHistory);

        System.out.println("3개 일치 (5,000원) - " + winningHistory.getRank5Number() + "개");
        System.out.println("4개 일치 (50,000원) - " + winningHistory.getRank4Number() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningHistory.getRank3Number() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningHistory.getRank2Number() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningHistory.getRank1Number() + "개");

        double yield = (double) totalWinningAmount / amount * 100;
        System.out.println("총 수익률은 " + Math.round(yield * 10) / 10.0 + "%입니다.");
    }

    private static int getTotalWinningAmount(int count, int totalWinningAmount, List<Lotto> lottoList,
                                             List<Integer> winningNumber, int bonusNumber, WinningHistory winningHistory) {

        totalWinningAmount = lottoListCheck(count, totalWinningAmount, lottoList, winningNumber, bonusNumber, winningHistory);
        return totalWinningAmount;
    }

    private static int lottoListCheck(int count, int totalWinningAmount, List<Lotto> lottoList,
                                      List<Integer> winningNumber, int bonusNumber, WinningHistory winningHistory) {
        for (Lotto lotto : lottoList) {
            count = countWinningNumbers(count, winningNumber, lotto);

            if (count == 6) {
                totalWinningAmount = rank1Win(totalWinningAmount, winningHistory);
                continue;
            }

            if (count == 5 && lotto.getNumbers().contains(bonusNumber)) {
                totalWinningAmount = rank2Win(totalWinningAmount, winningHistory);
                continue;
            }

            if (count == 5) {
                totalWinningAmount = rank3Win(totalWinningAmount, winningHistory);
                continue;
            }

            if (count == 4) {
                totalWinningAmount = rank4Win(totalWinningAmount, winningHistory);
                continue;
            }

            if (count == 3) {
                totalWinningAmount = rank5Win(totalWinningAmount, winningHistory);
                continue;
            }

            count = 0;
        }
        return totalWinningAmount;
    }

    private static int rank5Win(int totalWinningAmount, WinningHistory winningHistory) {
        totalWinningAmount += Winnings.오천.winnings();
        winningHistory.setRank5Number(winningHistory.getRank5Number() + 1);
        return totalWinningAmount;
    }

    private static int rank4Win(int totalWinningAmount, WinningHistory winningHistory) {
        totalWinningAmount += Winnings.오만.winnings();
        winningHistory.setRank4Number(winningHistory.getRank4Number() + 1);
        return totalWinningAmount;
    }

    private static int rank3Win(int totalWinningAmount, WinningHistory winningHistory) {
        totalWinningAmount += Winnings.백오십만.winnings();
        winningHistory.setRank3Number(winningHistory.getRank3Number() + 1);
        return totalWinningAmount;
    }

    private static int rank2Win(int totalWinningAmount, WinningHistory winningHistory) {
        totalWinningAmount += Winnings.삼천만.winnings();
        winningHistory.setRank2Number(winningHistory.getRank2Number() + 1);
        return totalWinningAmount;
    }

    private static int rank1Win(int totalWinningAmount, WinningHistory winningHistory) {
        totalWinningAmount += Winnings.이십억.winnings();
        winningHistory.setRank1Number(winningHistory.getRank1Number() + 1);
        return totalWinningAmount;
    }

    private static int countWinningNumbers(int count, List<Integer> winningNumber, Lotto lotto) {
        for (int i = 0; i < lotto.getNumbers().size(); i++) {
            if (winningNumber.contains(lotto.getNumbers().get(i))) {
                count += 1;
            }
        }
        return count;
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
        int bonusNumber = getAmount(user.enterBonusNumber(winningNumber));

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
