package lotto;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    //발행한 로또와 당첨번호를 비교한다
    public 당첨 compareLotto(List<Integer> winningNumber, int bonusNumber){
        int matchingCount=0;
        HashSet<Integer> winningSet = new HashSet<>(winningNumber);
        for(int number:numbers){
            if(winningSet.contains(number))
                matchingCount++;
        }
        return 당첨.getRank(matchingCount,winningSet.contains(bonusNumber));
    }
}
