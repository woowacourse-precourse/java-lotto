package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.List;
import java.util.Map;

public class View {
    public static String printUserInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static void printUserLotto(List<Lotto> userLotto) {
        for (Lotto lottoPiece : userLotto) {
            System.out.println(lottoPiece.getNumbers());
        }
    }

    public static String printUserInputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String printUserInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static void printWinningResult(Map<Integer, Integer> result) {

    }
}
