package lotto;

import java.util.List;

import static lotto.LottoConstant.*;
import static lotto.LottoErrorMessage.*;
import static lotto.LottoSeller.printMessage;

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
            printMessage(LOTTO_SIZE_ERROR_MSG);
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR_MSG);
        }

        if (hasDuplicateNumber(numbers)) {
            printMessage(DUPLICATE_NUM_ERROR_MSG);
            throw new IllegalArgumentException(DUPLICATE_NUM_ERROR_MSG);
        }

        if (hasOutOfRangeNumber(numbers)) {
            printMessage(LOTTO_RANGE_ERROR_MSG);
            throw new IllegalArgumentException(LOTTO_RANGE_ERROR_MSG);
        }
    }

    private boolean hasDuplicateNumber(List<Integer> numbers) {
        long size = numbers.stream().distinct().count();

        if (size != numbers.size())
            return true;

        return false;
    }

    private boolean hasOutOfRangeNumber(List<Integer> numbers) {
        for (int i = 0; i < LOTTO_SIZE; i++) {
            int number = numbers.get(i);

            if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
                printMessage(LOTTO_RANGE_ERROR_MSG);
                return true;
            }
        }
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
