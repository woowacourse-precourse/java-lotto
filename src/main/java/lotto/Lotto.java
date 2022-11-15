package lotto;

import java.util.HashMap;
import java.util.List;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // 보너스 숫자를 추가하는 메서드
    public void addBonus(int bonus){
        if(this.numbers.contains(bonus)) {
            System.out.println("[ERROR] 이미 선택한 숫자입니다.");
            throw new IllegalArgumentException();
        }
        numbers.add(bonus);
    }

    // 로또 번호맞추기 (보너스 제외)
    public int calculCorrect(List<Integer> boughtLotto){
        int correct = 0;
        List<Integer> correctNumbers = this.numbers.subList(0,7);
        for (Integer lotto : boughtLotto) {
            if (correctNumbers.contains(lotto)) correct++;
        }
        return correct;
    }

    // 보너스 번호 맞추기
    public int calculBonus(List<Integer> boughtLotto){
        int bonus = 0;
        if(boughtLotto.contains(this.numbers.get(6))) bonus++;
        return bonus;
    }
}
