package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputManager {

    public int getPurchasingAmount() {
        System.out.println("구입금액을 입력해주세요.");
        int amount = Integer.parseInt(Console.readLine());

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 급액은 1000원 단위여야 합니다.");
        }

        return amount;
    }

    public List<Integer> drawWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNumberInput = Console.readLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String winningNumber : winningNumberInput) {
            winningNumbers.add(Integer.parseInt(winningNumber));
        }

        return winningNumbers;
    }
}
