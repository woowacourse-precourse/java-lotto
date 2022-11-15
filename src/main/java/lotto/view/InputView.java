package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validation;

public class InputView {
    public static String getMoney() {
        String input = Console.readLine();
        try {
            Validation.validateMoney(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return input;
    }

    public static String getLottoNumbers() {
        String input = Console.readLine();

        try {
            Validation.validateLottoNumbers(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return input;
    }

    public static String getBonusNumber() {
        String input = Console.readLine();

        try {
            Validation.validateBonusNumbers(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return input;
    }

}
