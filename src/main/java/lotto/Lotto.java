package lotto;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.");
        }
        for(int number:numbers){
            if(number<1 || number>45)
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void checkDuplicate(List<Integer> numbers){
        for(int i=0;i<5;i++){
            if(numbers.get(i)==numbers.get(i+1))
                throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.");
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
