package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static int enterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String data = Console.readLine();
        InputException.validatePurchaseAmount(data);
        int purchaseAmount = Integer.valueOf(data);
        System.out.println();
        return purchaseAmount;
    }

    public static List<Integer> enterWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] numbers = Console.readLine().split(",");
        List<Integer> winningNumber = Arrays.stream(numbers)
                .map(number -> Integer.valueOf(number))
                .collect(Collectors.toList());
        InputException.validateWinningNumber(winningNumber);
        Collections.sort(winningNumber);
        System.out.println();
        return winningNumber;
    }

    public static int enterBonusNumber(List<Integer> winningNumber) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.valueOf(Console.readLine());
        InputException.validateBonusNumber(bonusNumber, winningNumber);
        System.out.println();
        return bonusNumber;
    }

}
