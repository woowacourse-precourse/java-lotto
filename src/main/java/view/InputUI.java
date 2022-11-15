package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InputUI {
    final static int MAX_LOTTO_LENGTH = 6;

    // 구입할 금액 입력
    public String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();

        return amount;
    }

    // 당첨 번호 입력
    public String[] inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요.");
        String winningNumbers = Console.readLine();
        String[] tempWinningNumbers = winningNumbers.split(",");

        return tempWinningNumbers;
    }

    // 보너스 번호 입력
    public int inputBonusNumber() {
        // 보너스 번호 입력 기능 구현
        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        return bonusNumber;
    }
}
