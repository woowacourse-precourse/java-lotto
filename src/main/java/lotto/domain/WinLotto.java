package lotto.domain;

import lotto.domain.message.ErrorMessages;

import java.util.ArrayList;
import java.util.List;

public class WinLotto{
    Lotto lotto;

    public WinLotto(String input) {
        List<Integer> numbers = validate(input);
        this.lotto = new Lotto(numbers);
    }

    public Lotto get() {
        return lotto;
    }

    public int validateBonus(String input) {
        if (!isNumeric(input)) {
            System.out.println(ErrorMessages.BONUS_NUM_FORMAT_ERROR.get());
            throw new IllegalArgumentException();
        }
        int bonus = Integer.parseInt(input);
        if (bonus < 1 || bonus > 45) {
            System.out.println(ErrorMessages.BONUS_NUM_RANGE_ERROR.get());
            throw new IllegalArgumentException();
        }
        if (lotto.getNumbers().contains(bonus)) {
            System.out.println(ErrorMessages.BONUS_NUM_DUPLICATE_ERROR.get());
            throw new IllegalArgumentException();
        }
        return bonus;
    }

    private static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    private List<Integer> validate(String input) {
        List<Integer> numbers = new ArrayList<>();

        for(String elm : input.split(",")) {
            int num;
            try {
                num = Integer.parseInt(elm);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessages.LOTTO_NUM_FORMAT_ERROR.get());
            }
            numbers.add(num);
        }
        return numbers;
    }
}
