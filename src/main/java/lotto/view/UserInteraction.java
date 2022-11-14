package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.datamodel.util.Transform;

import java.util.ArrayList;
import java.util.List;

public class UserInteraction {
    private static final String PAYMENT = "구입금액을 입력해 주세요.";
    private static final String PAY_COUNT = "개를 구매했습니다.";
    private static final String INPUT_WIN_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private final Transform transformer = new Transform();

    public UserInteraction() {
    }

    public String inputMoney() {
        System.out.println(PAYMENT);
        return Console.readLine();
    }

    public void showLotto(int count, List<List<Integer>> numbers) {
        System.out.println("\n" + count + PAY_COUNT);
        for(int i = 0; i < count; i++) {
            System.out.println(numbers.get(i));
        }
    }

    public List<Integer> winningNumbers() {
        System.out.println(INPUT_WIN_NUMBER);
        String input = Console.readLine();
        return transformer.numberTransform(input);
    }

    public int bonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String input = Console.readLine();
        return transformer.bonusTransform(input);
    }

    public void printResult(int lottoCount, float totalPrize, List<String> moneyInfo, List<Integer> winingLotto) {
        System.out.println("\n 당첨 통계");
        System.out.println("---");

        for(int prizeCount = 0; prizeCount < 5; prizeCount++){
            System.out.print(moneyInfo.get(prizeCount));
            System.out.print(" - ");
            System.out.println(winingLotto.get(prizeCount)+"개");
        }
        System.out.println("총 수익률은 " + String.format("%.1f", totalPrize/lottoCount * 100)+"%입니다.");
    }
}
