package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Application {

    private static Integer purchaseAmount;
    private static List<Integer> winningNumbers = new ArrayList<>();
    private static Integer bonusNumber;

    private static void enterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        purchaseAmount = Integer.valueOf(readLine());
    }

    private static void enterWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] temp = readLine().split(",");
        for(String num : temp) {
            winningNumbers.add(Integer.valueOf(num));
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.valueOf(readLine());
    }

    public static void main(String[] args) {
        enterPurchaseAmount();
        // generateLottoNumbers();
        enterWinningNumbers();
    }
}
