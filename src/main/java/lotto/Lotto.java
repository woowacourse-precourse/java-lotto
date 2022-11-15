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
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        final String INPUT_PATTERN = "^[1-9]$|^[1-3][0-9]$|^4[0-5]$";
        final String SIZE_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 중복된 숫자 또는 6개의 숫자가 입력되지 않았습니다.";
        final String RANGE_EXCEPTION_MESSAGE = "1-45를 벗어나는 문자를 입력할 수 업습니다.";

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException(SIZE_DUPLICATE_EXCEPTION_MESSAGE);
        }

        for (int number : numbers) {
            boolean isMatch = Pattern.matches(INPUT_PATTERN, Integer.toString(number));

            if (!isMatch) {
                throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
            }
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
