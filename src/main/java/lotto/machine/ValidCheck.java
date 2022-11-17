package lotto.machine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static lotto.ui.ErrorMessage.*;

public class ValidCheck {
    public static void Lotto_length(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_LENGTH_ERROR.getErrorMessage());
        }
    }

    public static void Lotto_range(List<Integer> numbers) {
        for(int count = 0; count<numbers.size(); count++){
            if(numbers.get(count) > 45 || numbers.get(count) < 1){
                throw new IllegalArgumentException(LOTTO_RANGE_ERROR.getErrorMessage());
            }
        }
    }

    public static void Lotto_duplicated(List<Integer> numbers) {
        List<Integer> new_numbers = delete_overlapped(numbers);
        if(new_numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_DUPLICATED_ERROR.getErrorMessage());
        }
    }

    private static List<Integer> delete_overlapped(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return new ArrayList<>(set);
    }

    public static void Bonus(Integer Bonus, List<Integer> Winning_numbers) {
        Bonus_range(Bonus);
        Bonus_duplicated(Bonus, Winning_numbers);
    }

    private static void Bonus_range(Integer Bonus) {
        if(Bonus > 45 || Bonus < 0){
            throw new IllegalArgumentException(BONUS_RANGE_ERROR.getErrorMessage());
        }
    }

    private static void Bonus_duplicated(Integer Bonus, List<Integer> Winning_numbers) {
        if(Winning_numbers.contains(Bonus)) {
            throw new IllegalArgumentException(BONUS_DUPLICATED_ERROR.getErrorMessage());
        }
    }

    public static void money(Integer money) {
        if(money < 1000 || money%1000 > 0) {
            throw new IllegalArgumentException(MONEY_RANGE_ERROR.getErrorMessage());
        }
    }
}
