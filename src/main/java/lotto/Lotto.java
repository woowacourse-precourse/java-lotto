package lotto;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> numberChecker = new HashSet<>(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        } else if(numbers.size() != numberChecker.size()){
            throw new IllegalArgumentException();
        }
        System.out.println(numbers);
    }

    /**
     * 당첨번호가 몇개인지 확인하는 메서드
     * @param winningNumbers 당첨번호가 들어있는 정수 리스트
     * @return 몇개가 당첨됐는지 리턴
     */
    public int getNumberOfWins(List<Integer> winningNumbers){
        int count = 0;
        for(int number : winningNumbers){
            if(numbers.contains(number)){
                count++;
            }
        }
        return count;
    }

    /**
     * 보너스 번호가 당첨됐는지 확인
     * @param bonusNumber 보너스 번호
     * @return 당첨되면 참, 아니면 거짓
     */
    public boolean isHavingBonusNumber(int bonusNumber){
        return numbers.contains(bonusNumber);
    }
}
