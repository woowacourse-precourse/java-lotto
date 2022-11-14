package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        int[] nums = new int[46];
        for(int num : numbers) {
            nums[num]++;
            if (nums[num] > 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    public boolean contains(int num) {
        return this.numbers.contains(num);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
