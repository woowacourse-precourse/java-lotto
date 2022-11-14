package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            int purchaseAmount = askPurchaseAmount();
            int lottoCount = Purchase.getLottoCount(purchaseAmount);

            Generator generator = new Generator(lottoCount);
            List<List<Integer>> playerLotto = generator.createLotto();

            Lotto lotto = new Lotto(askWinningNumber());
            int bonusNumber = askBonusNumber();
            int prizeMoney = lotto.getPrizeMoney(playerLotto, bonusNumber);

            lotto.showWinningStatistics();
            Profit.showRate(purchaseAmount, prizeMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());;
        }
    }

    private static int askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Change.number(Console.readLine());
        System.out.println();
        return purchaseAmount;
    }

    private static List<Integer> askWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = Change.lottoNumber(Console.readLine());
        System.out.println();
        return winningNumber;
    }

    private static int askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Change.bonusNumber(Console.readLine());
        System.out.println();
        return bonusNumber;
    }
}
