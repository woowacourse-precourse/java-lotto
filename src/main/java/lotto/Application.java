package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Change;
import lotto.domain.Generator;
import lotto.domain.Lotto;
import lotto.domain.Purchase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = askPurchaseAmount();
        int lottoCount = Purchase.getLottoCount(purchaseAmount);
        Generator generator = new Generator(lottoCount);
        List<List<Integer>> playerLotto = generator.createLotto();
        Lotto lotto = new Lotto(askWinningNumber());

        int bonusNumber = askBonusNumber();

        int prizeMoney = lotto.getPrizeMoney(playerLotto, bonusNumber);
        System.out.println(prizeMoney);

    }

    private static int askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
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
        int bonusNumber = Integer.parseInt(Console.readLine());
        System.out.println();
        return bonusNumber;
    }
}
