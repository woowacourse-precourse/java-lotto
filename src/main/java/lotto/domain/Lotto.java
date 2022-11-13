package lotto.domain;

import lotto.domain.Prize;

import java.util.List;

public class Lotto {
    private static final int NUMBER_AMOUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_AMOUNT) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers(){
        return numbers;
    }
    private int countMatch(List<String> winningNumbers, int bonusNumber) {
        int count = 0;

        for (String number: winningNumbers){
            if (this.numbers.contains(Integer.valueOf(number))){
                count++;
            }
        }
        if (count == NUMBER_AMOUNT){
            count++;
        }
        else if (count == NUMBER_AMOUNT -1 && this.numbers.contains(bonusNumber)){
            count++;
        }

        return count;
    }

    public int checkRanking(List<String> winningNumbers, int bonusNumber){
        int count = countMatch(winningNumbers, bonusNumber);

        for (Prize prize:Prize.values()){
            if (prize.getCount() == count){
                return prize.getName();
            }
        }
        return Prize.NOTHING.getName();
    }
}
