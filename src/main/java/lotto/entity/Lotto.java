package lotto.entity;

import lotto.Enum.LottoInfo;
import lotto.utils.Validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            Validation.throwException("[ERROR] 중복된 번호는 입력할 수 없습니다.");
        }
        if (numbers.size() > LottoInfo.COUNT.getInfo()) {
            Validation.throwException(LottoInfo.COUNT.getInfo()+"개의 숫자를 입력해 주세요.");
        }
    }



    public List<Integer> getNumbers() {
        return numbers;
    }
}

