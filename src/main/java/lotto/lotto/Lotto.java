package lotto.lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        numbers = sortList(numbers);
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validateLottoSize(numbers);
        LottoValidator.validateDuplicateNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }

    public void setBonusNumber(String input) {
        LottoValidator.validateLottoNumber(input);
        numbers.add(Integer.parseInt(input));
        LottoValidator.validateDuplicateNumbers(numbers);
    }

    private List<Integer> sortList(List<Integer> unsortedList) {
        Integer[] arr = unsortedList.toArray(new Integer[0]);
        return Arrays.stream(arr).sorted().collect(Collectors.toList());
    }
}
