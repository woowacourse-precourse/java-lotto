package lotto;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static lotto.I_O_System.BAGIC_ERROR_MESSAGE;

public class Lotto {
    private final List<Integer> numbers;
    public  static int Bounus_Win = 0;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        check_duplicate_numbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(BAGIC_ERROR_MESSAGE);

        }
    }

    // TODO: 추가 기능 구현
    private void check_duplicate_numbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (Collections.frequency(numbers, numbers.get(i)) != 1)
                throw new IllegalArgumentException(BAGIC_ERROR_MESSAGE);
        }
    }

    public void Check_Lottey(int Bonus_Number, List<Integer> Winning_Number, List<List<Integer>> mylist) {
        I_O_System IO = new I_O_System();
        int[] Number_of_Win = {0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < mylist.size(); i++) {
           Check_Winning_Number(Winning_Number, mylist.get(i), Number_of_Win);
        }
        IO.Number_of_Win_Print(Number_of_Win);
    }

    private void Check_Winning_Number(List<Integer> Winning_Number, List<Integer> numbers,int[] Number_of_Win) {
        List<Integer> matchList = Winning_Number.stream().filter(o -> numbers.stream()
                .anyMatch(Predicate.isEqual(o))).collect(Collectors.toList());
        Number_of_Win[matchList.size()]+=1;
    }


}
