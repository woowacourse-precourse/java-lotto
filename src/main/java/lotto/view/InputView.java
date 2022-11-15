package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private String purchaseMoney;
    private String winningNumbers;
    private String bonusNumber;

    public String enterPurchaseMoney() {
        OutputView.printEnterPurchaseAmount();
        this.purchaseMoney = Console.readLine();
        return purchaseMoney;
    }


    public List<Integer> enterWinningNumbers() {
        OutputView.printEnterWinningNumbers();
        this.winningNumbers = Console.readLine();
        return changeTypeForSystem(winningNumbers);
    }

    public int enterBonusNumber() {
        OutputView.printEnterBonusNumber();
        this.bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }

    private List<Integer> changeTypeForSystem(String winningNumbers) {
        return Arrays.asList(winningNumbers.split(","))
                .stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }
}


