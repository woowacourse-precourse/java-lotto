package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static lotto.Error.*;

public class Input {
    // 구입 금액 입력 기능
    public static int EnterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        System.out.println();

        if (purchaseAmount.matches("(.*)[^0-9](.*)")) {
            System.out.println(INVALID_INPUT.getMessage());
            throw new NoSuchElementException(INVALID_INPUT.getMessage());
        }

        try {
            Integer purchaseAmountInteger = Integer.parseInt(purchaseAmount);
            if (purchaseAmountInteger % 1000 != 0) throw new IllegalArgumentException(INVALID_MONEY_INPUT.getMessage());

            return purchaseAmountInteger;
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_TYPE.getMessage());
        }
    }

    // 당첨 번호 입력 기능
    public static List<Integer> EnterWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        System.out.println();
        try {
            List<Integer> winningNumberList = Arrays.stream(winningNumber.split(",")).map(i -> Integer.valueOf(i)).collect(Collectors.toList());
            if (winningNumberList.stream().distinct().collect(Collectors.toList()).size() != 6)
                throw new IllegalArgumentException(REDUPLICATION_INPUT.getMessage());
            return winningNumberList;
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    // 보너스 번호 입력 기능
    public static int EnterBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        System.out.println();
        try {
            return Integer.valueOf(bonusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_BONUS_INPUT.getMessage());
        }
    }
}