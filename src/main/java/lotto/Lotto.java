package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto { // Lotto-create-001
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) { // WinningStatistics-valid-001
        if (numbers.size() != 6) {
            System.out.println(Message.ILLEGAL_ARGUMENT_ERROR_MESSAGE.getMessage());
            throw new IllegalArgumentException();
        }
        Set<Integer> checkOverlap = new HashSet<>();
        for (Integer winningNumber : numbers){
            if (winningNumber < 1 || winningNumber > 45 || checkOverlap.contains(winningNumber)) {
                System.out.println(Message.ILLEGAL_ARGUMENT_ERROR_MESSAGE.getMessage());
                throw new IllegalArgumentException();
            }
            checkOverlap.add(winningNumber);
        }
    }

    @Override
    public boolean equals(Object obj) {
        Lotto lotto = (Lotto) obj;
        return new HashSet<>(this.numbers).containsAll(lotto.numbers);
    }

    public List<Integer> getNumbers(){ // Lotto-print-001
        return this.numbers;
    }

    public int getCorrectNumber(Lotto winningNumbers){ // WinningStatistics-compare-001
        int correctNumber = 0;
        for (Integer winningNumber : winningNumbers.getNumbers()){
            if (this.numbers.contains(winningNumber)){
                correctNumber += 1;
            }
        }
        return correctNumber;
    }

    public boolean hitBonus(int bonus){ // WinningStatistics-compare-001
        return this.numbers.contains(bonus);
    }
}
