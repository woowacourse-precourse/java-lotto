package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public int getMoney() {
        int money = 0;

        try {
            String input = Console.readLine();
            money = Validation.validateMoney(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return money;
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();

        try {
            String input = Console.readLine();
            numbers = Validation.validateLottoNumbers(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return numbers;
    }

    public int getBonusNumber() {
        int bonus = 0;

        try {
            String input = Console.readLine();
            bonus = Validation.validateBonusNumbers(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return bonus;
    }

}
