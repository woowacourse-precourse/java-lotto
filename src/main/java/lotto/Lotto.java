package lotto;

import java.util.List;

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

    // TODO: 추가 기능 구현
    public void VALIDATE_BONUS_NO(int Input){
        if((Input > 45) || (Input < 1)){
            System.out.println("[ERROR] 보너스 번호가 1 ~ 45 사잇값이 아닙니다.");
            throw new IllegalArgumentException();
        }
        if(numbers.contains(Input)){
            System.out.println("[ERROR] 보너스 번호가 로또 번호에 포함되어 있습니다.");
            throw new IllegalArgumentException();
        }
    }
}
