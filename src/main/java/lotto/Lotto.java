package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer number : numbers) {
            sb.append(number).append(", ");
        }
        sb.setLength(sb.length()-2);
        sb.append("]");

        return sb.toString();
    }
}
