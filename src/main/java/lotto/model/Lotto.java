package lotto.model;

import lotto.resource.ErrorType;
import lotto.view.Error;

import java.util.List;


public class Lotto {
    public static final int MIN_LOTTO_NUM = 1;
    public static final int MAX_LOTTO_NUM = 45;
    public static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int countNumberOfMatching(Lotto userLotto) {
        int count = 0;
        for (int i = 0; i < LOTTO_SIZE; i++) {
            int userNumber = numbers.get(i);

            if (userLotto.hasNumber(userNumber)) {
                count++;
            }
        }

        return count;
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE)
            Error.printException(ErrorType.SIZE);

        if (hasDuplicateNumber(numbers))
            Error.printException(ErrorType.DUPLICATE);

        if (hasOutOfRangeNumber(numbers))
            Error.printException(ErrorType.RANGE);
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
                Error.printException(ErrorType.RANGE);
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
