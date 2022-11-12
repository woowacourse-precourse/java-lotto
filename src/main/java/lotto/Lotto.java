package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = getSortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 6개가 아닙니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 중 중복이 있습니다.");
        }
    }

    // List.of() 리스트를 정렬하기 위해 리스트를 새로 만들고 정렬한 리스트를 반환하는 메스드
    private List<Integer> getSortNumbers(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>(numbers);
        list.sort(Integer::compareTo);
        return list;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
