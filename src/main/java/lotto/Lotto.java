package lotto;

import java.util.List;

import static lotto.LottoNumber.LOTTO_SIZE;

public class Lotto {
    private static final String ERROR_MSG = "[ERROR] 로또 번호는 1~45 사이의 중복되지 않은 6개의 숫자입니다";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            System.out.println(ERROR_MSG);
            throw new IllegalArgumentException();
        }

        if (hasDuplicateNumber(numbers)) {
            System.out.println(ERROR_MSG);
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
