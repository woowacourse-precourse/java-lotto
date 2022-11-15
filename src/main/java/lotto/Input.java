package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "\n보너스 번호를 입력해주세요.";

    public int inputPurchaseAmount(){
        System.out.println(PURCHASE_AMOUNT);
        int buyPrice = Integer.parseInt(Console.readLine());
        System.out.println();

        return buyPrice;
    }

    public List<Integer> inputWinningNumbers(){
        System.out.println(WINNING_NUMBERS);
        List<Integer> winningNumber;
        winningNumber = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return winningNumber;
    }

    public int inputBonusNumber(){
        System.out.println(BONUS_NUMBER);
        int bonusNumber;
        bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }
}
