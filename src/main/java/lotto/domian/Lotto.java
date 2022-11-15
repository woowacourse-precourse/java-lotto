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
    public List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_LOTTO_NUMBERS; i++) {
            winningNumbers.add(numbers.get(i));
        }
        return winningNumbers;
    }
    public int getBonusNumber() {
        return numbers.get(BONUS_NUMBER_INDEX);
    }
    public void setBonusNumber(int bonusNumber) {
        validate(getWinningNumbers(), bonusNumber);

        this.numbers.add(bonusNumber);
    }
    private void validate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            System.out.println(ERROR_MESSAGE + "보너스 번호가 로또 당첨 번호와 중복됩니다.");
            throw new IllegalArgumentException();
        }
    }
}
