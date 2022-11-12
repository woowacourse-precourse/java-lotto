package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Game;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
       // validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }


    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public static Lotto get() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public int get_hitCount(List<Integer> winning_numbers) {
        int hit_Count = 0;
        for (int checkNumber : numbers) {
            if (winning_numbers.contains(checkNumber)) hit_Count++;
        }
        return hit_Count;
    }
    public boolean bonus_hit(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public void print(){
        Game.ascendingSort(numbers);
        for(int number : numbers) {
            System.out.print(number);
            System.out.print(", ");
        }
    }
}
