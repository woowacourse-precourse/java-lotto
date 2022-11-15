package lotto;

import java.util.ArrayList;
import java.util.List;

import static constants.Constant.*;
import static constants.ErrorMessage.*;

public class LottoDrawing {
    List<Integer> winningNumbers = new ArrayList<>();
    int bonusNumber;

    public LottoDrawing(String inputWinning, String inputBonus) {
        List<Integer> winningNumbers = convertStringToNumberList(inputWinning);
        int bonusNumber = validateBonus(inputBonus);

        Lotto winningLotto = new Lotto(winningNumbers);
        winningNumbers = winningLotto.getNumbers();

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private List<Integer> convertStringToNumberList(String input) {
        String[] tempInputs = input.split(SPlIT_BY_THIS);
        List<Integer> numbers = new ArrayList<>();
        for (String number : tempInputs) {
            int temp = convertStringToInteger(number);
            numbers.add(temp);
        }
        return numbers;
    }

    private int validateBonus(String input) {
        int bonusNumber = convertStringToInteger(input);
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR_RANGE); //상수변경해야함 : 1 이상 45 이하의 숫자만 입력할 수 있습니다.
        }
        return bonusNumber;
    }

    private int convertStringToInteger(String input) {
        validateInteger(input);
        return Integer.parseInt(input);
    }

    private void validateInteger(String input) {
        if (!input.matches(REG_EXP_NUMBER_ONLY)) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER); //상수변경해야함 :숫자만 입력할 수 있습니다.
        }
    }

}
