package lotto.domain;

import lotto.Enum.ErrorCode;

import java.util.*;

public class Lotto {
    private final int MAX_SIZE = 6;
    private final int MAX_NUMBER = 45;
    private final int MIN_NUMBER = 1;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.forEach(this::rangeCheck);
        isDuplicate(numbers);
        Collections.sort(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != MAX_SIZE) {
            throw new IllegalArgumentException(ErrorCode.NOT_SIX_SIZE.getMessage());
        }
    }

    public void rangeCheck(int number){
        if(number<MIN_NUMBER||number>MAX_NUMBER){
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
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < MAX_SIZE; i++) {
            sb.append(numbers.get(i)).append(", ");
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append("]%n");
        System.out.printf(sb.toString());
    }

}
