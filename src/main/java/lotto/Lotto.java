package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    public final int LOTTO_LENGTH = 6;
    private final List<Integer> numbers;

    public HashSet<Integer> checkDuplicate;
    public int bonusNumber;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);

        this.numbers = numbers;
    }

    public void setBonusNumber(String bonusNumberInput){
        int bonusNumber;

        validateBonusNumberIsNumeric(bonusNumberInput);
        bonusNumber = Integer.parseInt(bonusNumberInput);

        validateBonusNumberDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            Error.ILLEGAL_LOTTO_LENGTH.wrongInput();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        checkDuplicate = new HashSet<Integer>();
        for (int n: numbers) {
            if (!checkDuplicate.add(n)){
                Error.LOTTO_NUM_DUPLICATE_ERROR.wrongInput();
            }
        }
    }

    private void validateBonusNumberIsNumeric(String bonusNumberInput){
        try{
            int temp = Integer.parseInt(bonusNumberInput);
        }
        catch(IllegalArgumentException e){
            Error.NOT_NUMERIC.wrongInput();
        }
    }

    private void validateBonusNumberDuplicate(int bonusNumber){
        if(!checkDuplicate.add(bonusNumber)){
            Error.LOTTO_NUM_DUPLICATE_ERROR.wrongInput();
        }
    }
}
