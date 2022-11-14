package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

enum Prize { FIRST, SECOND, THIRD, FOURTH, FIFTH, NONE };

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers = new ArrayList<>(numbers);
        numbers.sort(Comparator.naturalOrder());
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        List<Integer> winningNumbers = new ArrayList<>();

        for(String number: numbers.split(",")) {
            try {
                winningNumbers.add(Integer.parseInt(number));
            } catch (Exception e) {
                throw new IllegalArgumentException("숫자를 입력해야 합니다.");
            }
        }

        winningNumbers.sort(Comparator.naturalOrder());
        validate(winningNumbers);
        this.numbers = winningNumbers;
    }

    public void printNumbers() {
        System.out.println(this.numbers);
    }

    public boolean contains(Integer number) {
        return this.numbers.contains(number);
    }

    public Prize getResult(Lotto winning, Integer bonusNumber) {
        Integer matchCount = this.getMatchCount(winning);

        if(matchCount == 6)
            return Prize.FIRST;
        else if(matchCount == 5 && this.contains(bonusNumber))
            return Prize.SECOND;
        else if(matchCount == 5)
            return Prize.THIRD;
        else if(matchCount == 4)
            return Prize.FOURTH;
        else if(matchCount == 3)
            return Prize.FIFTH;
        return Prize.NONE;
    }

    private Integer getMatchCount(Lotto winning) {
        Integer matchCount = 0;

        for (Integer number: winning.numbers) {
            if (this.contains(number))
                matchCount++;
        }

        return matchCount;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException("6개의 숫자를 입력해야 합니다.");

        checkNumberDuplicated(numbers);
        checkNumberInRange(numbers);
    }

    private void checkNumberDuplicated(List<Integer> numbers) {
        Integer beforeNumber = -1;

        for (Integer number: numbers) {
            if (beforeNumber == number)
                throw new IllegalArgumentException("중복되지 않는 숫자를 입력해야 합니다.");
            beforeNumber = number;
        }
    }

    private void checkNumberInRange(List<Integer> numbers) {
        for (Integer number: numbers) {
            if (number < 1 || number > 45)
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
