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

        List<Integer> winningNumber = new ArrayList<Integer>();

        int bonusNumber = 0;

        try {
            amountValidation(amount);

            lotteryNumberOutput(amount);

            winningNumber = getWinningNumber(user);

            bonusNumber = getBonusNumber(user, winningNumber);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
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

    private static void lotteryNumberOutput(int amount) {
        Lotto[] lottos = new Lotto[amount / 1000];

        System.out.println(amount / 1000 + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            System.out.println(lotto.getNumbers());
        }

        System.out.println();

    }

    private static void amountValidation(int amount) {

        if (amount % 1000 != 0 || amount == -1) {
            throw new IllegalArgumentException("[ERROR] 천 원단위로 입력해 주세요.");
        }
    }
}
