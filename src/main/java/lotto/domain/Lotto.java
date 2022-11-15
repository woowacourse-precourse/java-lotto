package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]: OUT OF SIZE");
        }
        if (checkDuplicateNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR]: DUPLICATION!");
        }
        if (checkNotCorrectRange(numbers)) {
            throw new IllegalArgumentException("[ERROR]: HAVE A NUMBER OUT OF RANGE!");
        }
    }

    private Boolean checkDuplicateNumber(List<Integer> numbers) throws IllegalArgumentException{
        List<Integer> tempLottoNumber = new ArrayList<>(numbers);
        Set<Integer> numSet = new HashSet<>(tempLottoNumber);
        return numSet.size() != tempLottoNumber.size();
    }

    private Boolean checkNotCorrectRange(List<Integer> numbers) throws IllegalArgumentException{
        List<Integer> tempLottoNumber = new ArrayList<>(numbers);
        for (Integer eachUnit: tempLottoNumber) {
            if (!(eachUnit > 0 && eachUnit <= 45)) {
                return false;
            }
        }
        return true;
    }

    public int lottoChecker(List<Integer> winNumbers, int bonusNumber) {
        int rank = 6;
        int count = compareNumber(winNumbers, numbers);

        if (count == 6) rank = 1;
        if (count >= 3 && count < 6) {
            rank = rankCheck(count);
        }
        if (count == 5 && secondPlaceCheck(bonusNumber)) rank = 2;
        return rank;
    }

    private int rankCheck(int count) {
        int rank = 3, amount = 5, counter = 0;
        while (amount != count) {
            amount--;
            counter++;
        }
        return (rank + counter);
    }

    private int compareNumber(List<Integer> winNumbers, List<Integer> lottoNumbers) {
        int winCount = 0;
        for (Integer winNumber: winNumbers) {
            if (lottoNumbers.contains(winNumber)) {
               winCount++;
            }
        }
        return winCount;
    }

    private Boolean secondPlaceCheck(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
