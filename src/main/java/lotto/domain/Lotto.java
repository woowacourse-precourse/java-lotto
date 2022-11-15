package lotto.domain;

import java.util.List;
import lotto.app.Validation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validation validation = new Validation();

        validation.hasSixItems(numbers);
        validation.isInRange(numbers);
        validation.isNotDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public int getMatchNumber(Lotto winningLotto){
        int matchNumber = 0;

        for(int i = 0; i < 6; i++){
            if(winningLotto.numbers.contains(this.numbers.get(i)))
                matchNumber++;
        }

        return matchNumber;
    }
}
