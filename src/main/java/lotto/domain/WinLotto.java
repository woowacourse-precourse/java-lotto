package lotto.domain;

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
        int bonus;

        try {
            bonus = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUM_FORMAT_ERROR.get());
        }

        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUM_RANGE_ERROR.get());
        }

        if (lotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUM_DUPLICATE_ERROR.get());
        }

        return bonus;
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
