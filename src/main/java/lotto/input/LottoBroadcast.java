package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.UserInputValidator;

import java.util.ArrayList;
import java.util.List;

public class LottoBroadcast {

    List<Integer> winNumber = new ArrayList<>();

    public List<Integer> inputWinNumber() {
        String[] inputValue = Console.readLine().split(",");
        for (String value : inputValue) {
            UserInputValidator.validateInputLottoNumber(inputValue);
            this.winNumber.add(Integer.valueOf(value));
        }
        return this.winNumber;
    }

    public List<Integer> inputBonusNumber() {
        this.winNumber.add(Integer.valueOf(Console.readLine()));
        return this.winNumber;
    }
}
