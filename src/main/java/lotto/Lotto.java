package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import lotto.ErrorMessage;
import lotto.SystemMessage;
import lotto.Result;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_ERROR.print());
        }
    }

    private void validateRange(List<Integer> numbers) throws IllegalArgumentException {
        for(int i=0; i<numbers.size(); i++) {
            if (numbers.get(i) > 45 || numbers.get(i) < 1) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE_ERROR.print());
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_DUPLICATED.print());
                }
            }
        }
    }

    public boolean isContainBonus(Integer bonus){
        if(this.numbers.contains(bonus)) return true;
        else return false;
    }

    public Integer getNumbersOfMatch(List<Integer> num){
        int count=0;
        for(Integer a : num){
            if(this.numbers.contains(a)) count++;
        }
        return count;
    }

}
