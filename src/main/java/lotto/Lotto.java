package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    private static final String NOT_6_NUM = "[ERROR] 6개의 숫자만 입력해주세요.";
    private static final String OVERLAPPED = "[ERROR] 중복된 숫자가 있습니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(NOT_6_NUM);
            throw new IllegalArgumentException();
        }
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() != numbers.size()){
            System.out.println(OVERLAPPED);
            throw new IllegalArgumentException();
        }
    }


}
