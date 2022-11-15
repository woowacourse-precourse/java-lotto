package lotto;

import java.util.List;
import lotto.Constant.Ranking;
import lotto.Validate.HandleException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        HandleException.InputArgsNum(numbers, Application.lottoLength);
        HandleException.DuplicatedNum(numbers);
    }

    public Ranking countHit(List<Integer> hitNumber, int bonus){
        int count = 0;
        boolean bonusHit = false;
        for (Integer hit : hitNumber){
            if (numbers.contains(hit))
                count++;
        }
        if (numbers.contains(bonus))
            bonusHit = true;

        if (count == 6)
            return Ranking.FIRST;
        if (count == 5 && bonusHit)
            return Ranking.SECOND;
        if (count == 5 && !bonusHit)
            return Ranking.THIRD;
        if (count == 4)
            return Ranking.FOURTH;
        if (count == 3)
            return Ranking.FIFTH;
        return Ranking.SIXTH;
    }
    public void print(){
        System.out.println(numbers);
    }
}
