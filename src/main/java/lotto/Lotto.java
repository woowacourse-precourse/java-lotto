package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private static final int LENGTH_OF_LOTTO_NUMBERS = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int numberOfSameDigits(Lotto another) {
        List<Integer> myNumbersClone = new ArrayList<>(this.numbers);

        myNumbersClone.removeAll(another.numbers);

        // 같은 만큼 빠졌으므로, 빠진 개수를 구해야 함.
        // e.g. removeAll으로 1개 빠졌으면 6-5=1개가 나옴.
        return LENGTH_OF_LOTTO_NUMBERS - myNumbersClone.size();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }
}
