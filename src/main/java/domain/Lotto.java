package domain;

import camp.nextstep.edu.missionutils.Randoms;
import net.bytebuddy.implementation.bytecode.Throw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException(ErrorMessage.NOT_SIZE.getErrorMessage());
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> numbersOverlap = new HashSet<>(numbers);
        if (numbers.size() != numbersOverlap.size())
            throw new IllegalArgumentException(ErrorMessage.HAVE_DUPLICATION.getErrorMessage());
        }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
