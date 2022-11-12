package lotto.domain;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int bonusNum;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateScope(numbers);
        validateDuplicate(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void validateScope(List<Integer> numbers) {
        boolean isException = numbers.stream()
                .anyMatch(number -> number < 1 || 45 < number);
        if (isException)
            throw new IllegalArgumentException();
    }

    private void validateDuplicate(List<Integer> numbers) {
        int nonDuplNum = (int)numbers.stream()
                .distinct().count();
        if (nonDuplNum != numbers.size()){
            throw new IllegalArgumentException();
        }
    }
    public void addBonusNum(int bonusNum){
        this.bonusNum = bonusNum;
    }
    public int compare(List<Integer> numbers){
        int matchNum = (int)this.numbers.stream()
                .filter(num -> numbers.contains(num))
                .count();
        return matchNum;
    }
    public boolean hasBonusNum(List<Integer> numbers){
        if(numbers.contains(bonusNum))
            return true;
        return false;
    }




    // TODO: 추가 기능 구현
}
