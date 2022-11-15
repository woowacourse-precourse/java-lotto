package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validation;

public class InputView {
    public static String getMoney() {
        String input = Console.readLine();
        Validation.validateMoney(input);

        return input;
    }

    public static String getLottoNumbers() {
        String input = Console.readLine();
        Validation.validateLottoNumbers(input);

        return input;
    }

    public static String getBonusNumber() {
        String input = Console.readLine();
        Validation.validateBonusNumbers(input);

        return input;
    }

}
