package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int _min_lotto_number = 1;
    public static final int _max_lotto_number = 45;
    public static final int _lotto_length = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        List<Integer> newNumbers = new ArrayList<>(numbers);
        Collections.sort(newNumbers);

        this.numbers = newNumbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void showNumbers() {
        System.out.print(numbers + "\n");
    }

    public boolean hasNumber(int number) {
        return this.numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (isNumberNullOrEmpty(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 생성 시 빈 리스트는 사용할 수 없습니다.");
        }
        if (!hasSixNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또를 생성하기 위해선 6개의 번호가 필요합니다.");
        }
        for (int num : numbers) {
            if (hasDuplicateNumber(numbers, num)) {
                throw new IllegalArgumentException("[ERROR] 로또 생성 시 중복된 번호는 허용하지 않습니다.");
            }
            if (!checkRange(num)) {
                throw new IllegalArgumentException("[ERROR] 범위를 벗어난 로또 번호는 허용하지 않습니다.");
            }
        }
    }

    public static boolean checkRange(int num) {
        if (num >= _min_lotto_number && num <= _max_lotto_number) {
            return true;
        }
        return false;
    }

    private boolean isNumberNullOrEmpty(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean hasSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            return false;
        }
        return true;
    }

    private boolean hasDuplicateNumber(List<Integer> numbers, Integer number) {
        if (Collections.frequency(numbers, number) != 1) {
            return true;
        }
        return false;
    }
}
