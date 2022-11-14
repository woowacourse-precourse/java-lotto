package lotto;

import java.util.*;
import java.util.regex.Pattern;

/*
- 제공된 Lotto 클래스를 활용해 구현해야 한다.
- Lotto에 매개 변수가 없는 생성자를 추가할 수 없다.
- numbers의 접근 제어자인 private을 변경할 수 없다.
- Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
- Lotto의 패키지 변경은 가능하다.
*/

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        final String INPUT_PATTERN = "^[1-9]$|^[1-3][0-9]$|^4[0-5]$";

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }

        for (int number : numbers) {
            boolean isMatch = Pattern.matches(INPUT_PATTERN, Integer.toString(number));

            if (!isMatch) {
                throw new IllegalArgumentException("[ERROR]");
            }
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
