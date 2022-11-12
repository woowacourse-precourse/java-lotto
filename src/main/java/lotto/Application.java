package lotto;

import static lotto.Input.getBonusNumber;
import static lotto.Input.getPurchasePrice;
import static lotto.Input.getWinningNumbers;
import static lotto.Output.printLotteries;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = getPurchasePrice();
        int purchaseCount = purchasePrice / 1000;

        System.out.println();

        List<Lotto> lotteries = QuickPickGenerator.quickPick(purchaseCount);
        printLotteries(lotteries);

        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winningNumbers = new Lotto(getWinningNumbers());

        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = getBonusNumber();

        if (winningNumbers.getNumbers().indexOf(bonusNumber) != -1) {
            throw new IllegalArgumentException("[ERROR] 보너스번호가 당첨번호와 중복됩니다.");
        }



//        printWinningStatistics(lotteries, winningNumbers);
    }

}
