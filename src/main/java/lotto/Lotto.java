package lotto;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static lotto.I_O_System.BAGIC_ERROR_MESSAGE;

public class Lotto {
    private final List<Integer> numbers;
    public static int Bounus_Win = 0;


    private final int Tree_Matche_Money = 5000;
    private final int Four_Matche_Money = 50000;
    private final int Five_Matche_Money = 1500000;
    private final int Five_Matche_Money_Bonus = 30000000;
    private final int Six_Matche_Money = 2000000000;

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
        int Jackpot = 0;
        for (int i = 0; i < mylist.size(); i++) {
            Check_Winning_Number(Winning_Number, mylist.get(i), Number_of_Win, Bonus_Number);
        }
        Jackpot = Winning_Jackpot(Jackpot, Number_of_Win);
        IO.Number_of_Win_Print(Number_of_Win, Bounus_Win, Jackpot);
    }

    private void Check_Winning_Number(List<Integer> Winning_Number, List<Integer> numbers, int[] Number_of_Win, int Bonus_Number) {
        List<Integer> matchList = Winning_Number.stream().filter(o -> numbers.stream()
                .anyMatch(Predicate.isEqual(o))).collect(Collectors.toList());
        if (matchList.size() == 5) {
            Bonus_Check(Bonus_Number, numbers);
            return;
        }

        Number_of_Win[matchList.size()] += 1;
    }

    private int Winning_Jackpot(int Jackpot, int[] Number_of_Win) {
        int[] Jackpot_Money = {Tree_Matche_Money, Four_Matche_Money, Five_Matche_Money, Six_Matche_Money, Five_Matche_Money_Bonus};
        for (int i = 0; i < Jackpot_Money.length; i++) {
            Jackpot += Jackpot_Money[i] * Number_of_Win[i + 3];
            if (i == 4) {
                Jackpot += Jackpot_Money[i] * Bounus_Win;
            }
        }
        return Jackpot;
    }

    private void Bonus_Check(int Bonus_Number, List<Integer> numbers) {
        if (numbers.contains(Bonus_Number)) {
            Bounus_Win++;
        }
    }


}
