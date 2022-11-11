package lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
    }

    //로또 번호에 중복된 숫자가 있으면 예외가 발생한다
    private void duplicateNumber(List<Integer> numbers) {

            }
        // TODO: 추가 기능 구현
    }

