package lotto;

import java.util.ArrayList;
import java.util.List;

import static constants.Constant.*;
import static constants.ErrorMessage.*;

public class LottoDrawing {
    List<Integer> winningNumber = new ArrayList<>();
    int bonusNumber;

    public LottoDrawing(String inputWinning, String inputBonus) {
        this.winningNumber = validateWinningNumbers(inputWinning);
        this.bonusNumber = validateBonusNumber(inputBonus);
    }

    private List<Integer> validateWinningNumbers (String inputWinning){
        List<Integer> winningNumbers = convertStringToNumberList(inputWinning);

        Lotto winningLotto = new Lotto(winningNumbers);
        return winningLotto.getNumbers();
    }
    private int validateBonusNumber (String inputBonus){
        checkBonusInput(inputBonus);
        int bonusNumber = convertStringToInteger(inputBonus);
        checkRange(bonusNumber);
        bonusDuplicate(bonusNumber);
        return  bonusNumber;
    }


    private void checkBonusInput(String input) {
        if (!input.matches(REG_EXP_NUMBER_ONLY)) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }
    private List<Integer> convertStringToNumberList(String input) {
        String[] tempInputs = input.split(SPlIT_BY_THIS);
        List<Integer> numbers = new ArrayList<>();
        for (String number : tempInputs) {
            checkBonusInput(number);
            int temp = convertStringToInteger(number);
            numbers.add(temp);
        }
        return numbers;
    }

    private void checkRange(int input) {
        if (input < MIN_LOTTO_NUMBER || input > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }
    private void bonusDuplicate(int bonusNumber){
        for (int i = 0;i<winningNumber.size();i++){
            if(winningNumber.get(i) == bonusNumber){
                throw new IllegalArgumentException(ERROR_RANGE);
            }
        }
    }

    private int convertStringToInteger(String input) {
        return Integer.parseInt(input);
    }


}
