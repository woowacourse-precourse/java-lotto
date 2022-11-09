package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int cash = Integer.parseInt(Console.readLine());
        return cash;
    }

    public List<Integer> inputWinNumbers() {
        List<Integer> winNumbers = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        for (int i = 0; i < 6; i++) {
            int number = Integer.parseInt(Console.readLine());
            winNumbers.add(number);
        }
        return winNumbers;
    }

    public int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }
}
