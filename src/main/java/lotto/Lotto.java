package lotto;

import java.util.List;

import static lotto.LottoConstant.*;
import static lotto.LottoErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            System.out.println(LOTTO_SIZE_ERROR_MSG);
            throw new IllegalArgumentException();
        }

        if (hasDuplicateNumber(numbers)) {
            System.out.println(DUPLICATE_NUM_ERROR_MSG);
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicateNumber(List<Integer> numbers) {
        long size = numbers.stream().distinct().count();

        if (size != numbers.size())
            return true;

        return false;
    }

    @Override
    public String toString() {
        String str = "";

        str += "[";
        for (int i = 0; i < LOTTO_SIZE; i++) {
            str += numbers.get(i);
            if (LOTTO_SIZE - 1 != i)
                str += ", ";
        }
        str += "]";

        return str;
    }
}
