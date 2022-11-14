package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;

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

    public boolean contains(int lottoNum) {
        return numbers.contains(lottoNum);
    }

    public int matchCount(Lotto otherLotto) {
        return (int) (numbers.stream().filter(otherLotto::contains).count());
    }

    // TODO: 추가 기능 구현


    @Override
    public String toString() {
        List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');

        for (int i = 0; i < sorted.size(); i++) {
            stringBuffer.append(sorted.get(i));
            if (i != sorted.size() - 1) {
                stringBuffer.append(", ");
            }
        }

        stringBuffer.append(']');
        return stringBuffer.toString();
    }
}
