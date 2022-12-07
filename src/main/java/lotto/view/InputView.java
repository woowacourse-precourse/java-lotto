package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Buyer;
import lotto.domain.WinLotto;
import lotto.enums.StringEnum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.enums.StringEnum.*;

public class InputView {
    public void askBuyPricePrint() {
        System.out.println(PRICE.getMessage());
    }

    public Buyer makeBuyer() {
        askBuyPricePrint();
        String input = Console.readLine();
        digitValidate(input);
        int buyPrice = Integer.parseInt(input);
        return new Buyer(buyPrice);
    }

    public void digitValidate(String input) {
        String inputValidate = input.replaceAll("[0-9]", "");
        if (inputValidate.length() > 0) {
            throw new IllegalArgumentException("[ERROR] 입력값이 유효하지 않습니다.");
        }
    }



    private List<Integer> askWinNumber() {
        OutputView.askWinNumberPrint();
        String winNumberInput = Console.readLine();
        winNumberValidate(winNumberInput);
        String[] winNumber = winNumberInput.split(",");
        List<Integer> numbers = Arrays.stream(winNumber).map(Integer::parseInt).collect(Collectors.toList());
        return numbers;
    }

    public void winNumberValidate(String winNumber) {
        String inputValidate = winNumber.replaceAll("[0-9,]", "");
        if (inputValidate.length() > 0) {
            throw new IllegalArgumentException("[ERROR] 입력값이 유효하지 않습니다.");
        }
    }

    private Integer askBonus() {
        OutputView.askBonusNumberPrint();
        String bonus = Console.readLine();
        bonusValidate(bonus);
        return Integer.parseInt(bonus);
    }

    public void bonusValidate(String bonus) {
        if (!bonus.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }

    public WinLotto makeWinLotto() {
        List<Integer> winNumber = askWinNumber();
        Integer bonusInteger = askBonus();
        return new WinLotto(winNumber, bonusInteger);
    }
}
