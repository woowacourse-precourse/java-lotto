package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int getMoney() {
        int money = 0;

        try {
            String input = Console.readLine();
            money = Validation.validateMoney(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return money;
    }

    public static List<Integer> getLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();

        try {
            String input = Console.readLine();
            numbers = Validation.validateLottoNumbers(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return numbers;
    }

    public static int getBonusNumber() {
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
