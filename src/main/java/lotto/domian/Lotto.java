package lotto.domian;
import java.util.ArrayList;
import java.util.List;
import lotto.service.UserInputWinningNumberService;
import lotto.util.ArrayAndListTwoSidedConversion;

import static lotto.constant.Constant.*;


public class Lotto {
    private final List<Integer> numbers;
    UserInputWinningNumberService userInputWinningNumberService = new UserInputWinningNumberService();

    public Lotto(List<Integer> numbers) {
        String[] winningNumberArray = ArrayAndListTwoSidedConversion.integerListToStringArray(numbers);
        userInputWinningNumberService.checkThisWinningNumberIsValid(winningNumberArray);
        this.numbers = ArrayAndListTwoSidedConversion.stringArrayToIntegerList(winningNumberArray);
    }

}
