package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    public static List<Integer> readWinningLotto() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        List<Integer> winningLotto = new ArrayList<>();
        int number;
        for (String s : input) {
            try {
                number = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자를 입력해야 합니다.");
            }
            if(winningLotto.contains(number)){
                throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
            }
            winningLotto.add(number);
        }
        return winningLotto;
    }

    public static int readBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }
}
