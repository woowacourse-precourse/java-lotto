package lotto.domain;

import java.util.*;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.forEach(this::rangeCheck);
        isDuplicate(numbers);
        Collections.sort(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorCode.NOT_SIX_SIZE.getMessage());
        }
    }

    private void rangeCheck(int number){
        if(number<1||number>45){
            throw new IllegalArgumentException(ErrorCode.NOT_IN_LOTTO_RANGE.getMessage());
        }
    }

    private void isDuplicate(List<Integer> numbers){
        Set<Integer> testNumbers = new HashSet<>(numbers);
        if(numbers.size()!= testNumbers.size()){
            throw new IllegalArgumentException(ErrorCode.DUPLICATION_NUMBER.getMessage());
        }
    }

    public int countMatchNumber(List<Integer> winningNumbers){
        long count = numbers.stream().filter(winningNumbers::contains).count();
        return Math.toIntExact(count);
    }

    public boolean hasBonusNumber(int bonusNumber){
        return numbers.contains(bonusNumber);
    }

    public void printLotto(){
        System.out.printf("[%d, %d, %d, %d, %d, %d]%n",numbers.get(0),numbers.get(1),numbers.get(2),numbers.get(3),numbers.get(4),numbers.get(5));
    }

}
