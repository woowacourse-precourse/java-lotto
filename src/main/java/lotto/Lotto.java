package lotto;

import java.util.*;

// Lotto에 매개 변수가 없는 생성자를 추가할 수 없다.
// numbers의 접근 제어자인 private을 변경할 수 없다.
// Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
// Lotto의 패키지 변경은 가능하다.
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int number){
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }
        if (!validateRange(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45여야 합니다.");
        }

        if (!validateDuplicate(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private boolean validateRange(List<Integer> numbers){
        for (int number : numbers){
            if(number < 1 || number > 45){
                return false;
            }
        }
        return true;
    }

    private boolean validateDuplicate(List<Integer> numbers){
        Set<Integer> number = new HashSet<>(numbers);
        if(number.size() == 6){
            return true;
        }
        return false;
    }
}
