package lotto;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public List<Integer> getLotto() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (Objects.equals(numbers, "")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 존재하지 않습니다.");
        }
        if (numbers.size() != 6) {
            if (numbers.size() > 6){
                throw new IllegalArgumentException("[ERROR] 로또 번호가 6개 이상 입니다. 로또 번호는 6개이여야 합니다.");
            }
            throw new IllegalArgumentException("[ERROR] 로또 번호가 6개 이하 입니다. 로또 번호는 6개이여야 합니다.");
        }
        for (Integer number : numbers) {
            if(numbers.indexOf(number) != numbers.lastIndexOf(number)){
                throw new IllegalArgumentException("[ERROR] 중복된 번호가 있는지 확인해 주세요.");
            }
            if(!(1 <= number && number<= 45)){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
