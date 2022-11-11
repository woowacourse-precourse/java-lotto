package lotto.domain;


import java.util.HashSet;
import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;

    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateBonusNumber(Integer bonusNumber){
        if(numbers.contains(bonusNumber)){
            throw new IllegalArgumentException();
        }
    }

    public Integer checkMatchNumber(List<Integer> lottoNumbers){
        int count = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if(numbers.contains(lottoNumber)){
                count++;
            }
        }
        return count;
    }

    public boolean isThereBonusNumber(List<Integer> lottoNumber){
        boolean bonus = lottoNumber.contains(bonusNumber);
        return bonus;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
