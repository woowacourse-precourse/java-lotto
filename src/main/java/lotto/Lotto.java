package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 번호의 개수는 6이어야 합니다.");
        }

        Set<Integer> numberConsisted = new HashSet<>();
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 숫자의 범위는 1 ~ 45 입니다.");
            }
            numberConsisted.add(number);
        }
        if (numberConsisted.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }

    public void printNumbers() {
        System.out.println(Arrays.toString(numbers.toArray()));
    }

    public LottoResult getResult(List<Integer> normalNumbers, int bonusNumber) {
        int match = 0;
        boolean bonusMatch = false;
        for(int number: numbers) {
            if (normalNumbers.contains(number)) {
                match++;
            }
        }
        if(numbers.contains(bonusNumber)) {
            bonusMatch = true;
        }

        return LottoResult.getLottoResult(match, bonusMatch);
    }
}
