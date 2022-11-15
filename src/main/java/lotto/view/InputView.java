package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private String purchaseMoney;
    private String winningNumbers;
    private String bonusNumber;

    public int enterPurchaseMoney() {
        this.purchaseMoney = Console.readLine();
        return Integer.parseInt(purchaseMoney);
    }


    public List<Integer> enterWinningNumbers() {
        this.winningNumbers = Console.readLine();
        return changeTypeForSystem(replaceComma(winningNumbers));
    }

    public int enterBonusNumber() {
        this.bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }

    private String replaceComma(String winningNumbers) {
        return winningNumbers.replace(",", "");
    }

    private List<Integer> changeTypeForSystem(String winningNumbers) {
        return Arrays.asList(winningNumbers.split(""))
                .stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }
}


