package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(Collections.unmodifiableCollection(numbers));
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        Set<Integer> dupCheck = Set.copyOf(numbers);
        if(dupCheck.size() != 6){
            System.out.println("[ERROR] 로또 번호는 중복이 없어야만 합니다");
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    @Override
    public String toString() {
        String s = "[";
        for (Integer number : numbers) {
            s += number + ", ";
        }
        s = s.substring(0, s.length() - 2);
        s += "]";
        return s;
    }

    public int countNumMatch(Lotto lotto) {
        int count  = 0;
        for (Integer number : numbers) {
            if(lotto.hasContain(number)) count++;
        }
        return count;
    }

    public boolean hasContain(int number) {
        return numbers.contains(number);
    }
}
