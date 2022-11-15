package lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private boolean duplicateNumber(List<Integer> numbers) {
        for(Integer correctNumber : numbers){
            if (numbers.contains(correctNumber)) {
                throw new IllegalArgumentException();
                }
            }
        return true;
        }
    }

