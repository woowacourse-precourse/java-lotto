package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    // 구입 금액 입력 기능
    public static int EnterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();

        return Integer.valueOf(purchaseAmount);
    }

    // 당첨 번호 입력 기능
    public static List<Integer> EnterWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String winningNumber = Console.readLine();

        return Arrays.stream(winningNumber.split(",")).map(i -> Integer.valueOf(i)).collect(Collectors.toList());
    }
}
