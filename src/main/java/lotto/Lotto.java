package Exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자만 입력해주세요");
        }
        if (Set.copyOf(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력하지마세요.");
        }
        for(int number : numbers){
            if (!Pattern.matches("^[0-9]*$", String.valueOf(number))) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
            }
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1~45사이의 숫자만 입력해주세요.");
            }
        }

    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
