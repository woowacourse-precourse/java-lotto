package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public ranking countHit(List<Integer> hitNumber, int bonus){
        int count = 0;
        boolean bonusHit = false;
        for (Integer hit : hitNumber){
            if (numbers.contains(hit))
                count++;
        }
        if (numbers.contains(bonus))
            bonusHit = true;

        if (count == 6)
            return ranking.FIRST;
        if (count == 5 && bonusHit)
            return ranking.SECOND;
        if (count == 5 && !bonusHit)
            return ranking.THIRD;
        if (count == 4)
            return ranking.FOURTH;
        if (count == 3)
            return ranking.FIFTH;
        return ranking.SIXTH;
    }
    public void print(){
        System.out.println(numbers);
    }
}
