package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final List<Integer> numbersWithBonus;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {

        this.numbersWithBonus = createWinningLotto(numbers, bonusNumber);
    }

    public static List<Integer> createWinningLotto(List<Integer> numbers, int bonusNumber) {

        List<Integer> lottoNumbers = new ArrayList<>();

        for(int number : numbers) {
            verifyNumber(lottoNumbers, number);
            lottoNumbers.add(number);
        }

        verifyNumber(lottoNumbers, bonusNumber);
        lottoNumbers.add(bonusNumber);

        return lottoNumbers;
    }

    public static void verifyNumber(List<Integer> numbers, int number) {
        checkOutOfRange(number);
        checkDuplicated(numbers, number);
    }

    public static void checkOutOfRange(int number) {
        if (number < 1 || number > 45)
            throw new IllegalArgumentException("[ERROR] input error");
    }

    public static void checkDuplicated(List<Integer> numbers, int number) {
        if (numbers.contains(number))
            throw new IllegalArgumentException("[ERROR] input error");
    }
}
