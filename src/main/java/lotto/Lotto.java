package lotto;

import ui.ErrorConstant;
import user.NumberValidator;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = sortedNumbers(numbers);
    }

    public Lotto(String input) {
        validateLotto(stringToList(input));
        this.numbers = sortedNumbers(stringToList(input));
    }

    private List<Integer> sortedNumbers(List<Integer> numbers) {
        ArrayList<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    private List<Integer> stringToList(String input) {
        NumberValidator.validateWinningLotto(input);
        List<Integer> result = new ArrayList<>();
        String[] inputToArray = input.split(",");
        for (String str : inputToArray) {
            result.add(Integer.parseInt(str));
        }
        return result;
    }

    private void validateLotto(List<Integer> numbers) {
        validateLottoNull(numbers);
        validateLottoSize(numbers);
        validateLottoNumberNull(numbers);
        validateOutRange(numbers);
        validateLottoDuplicate(numbers);
    }

    private void validateLottoNull(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(ErrorConstant.LOTTO_NOT_NULL);
        }
    }
    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorConstant.LOTTO_NOT_SIZE_6);
        }
    }
    private void validateLottoNumberNull(List<Integer> numbers){
        for(Integer number : numbers){
            if(number == null){
                throw new IllegalArgumentException(ErrorConstant.LOTTO_NOT_NUMBER_NULL);
            }
        }
    }
    private void validateOutRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            NumberValidator.validateWinningLottoRange(number);
        }
    }

    private void validateLottoDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != 6) {
            throw new IllegalArgumentException(ErrorConstant.LOTTO_NOT_DUPLICATE);
        }
    }



    public String toNumberForm() {
        String message = "[%d, %d, %d, %d, %d, %d]";
        return String.format(message, numbers.get(0), numbers.get(1),
                numbers.get(2), numbers.get(3), numbers.get(4), numbers.get(5));
    }

    public boolean hasLottoNumber(int lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public int compareLotto(Lotto userLotto) {
        int correctCount = 0;
        for (int number : numbers) {
            if (userLotto.hasLottoNumber(number)) {
                correctCount++;
            }
        }
        return correctCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Lotto) {
            Lotto lotto = (Lotto) obj;
            return lotto.toNumberForm() == this.toNumberForm();
        }
        return false;
    }
}
