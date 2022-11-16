package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        
        //숫자가 6자리가 아닐 때 + 중복
        if (numbers.stream().distinct().collect(Collectors.toList()).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 6개의 수를 입력해 주세요.");
        }

        //1~45사이 숫자가 아닐 때
        if(numbers.stream().filter(v -> (v > 0 && v < 46)).collect(Collectors.toList()).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

    }

    public static void main(String[] args) {
        WiningLottoRequest wr = new WiningLottoRequest();
        List<Integer> l = wr.winningNumber("1,20,34,5,6,7");
        Lotto lotto = new Lotto(l);
        System.out.println(lotto.getNumbers());
    }

    // TODO: 추가 기능 구현
}
