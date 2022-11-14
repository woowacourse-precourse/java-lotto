package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Preset.LOTTO_MAX_VALUE;
import static lotto.domain.Preset.LOTTO_MIN_VALUE;

public class WinningLotto {

    public WinningLotto(List<Integer> numbers, int bonusNumber) {

        List<Integer> numbersWithBonus = createWinningLotto(numbers, bonusNumber);
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
        if (number < LOTTO_MIN_VALUE || number > LOTTO_MAX_VALUE)
            throw new IllegalArgumentException("[ERROR] input error");
    }

    public static void checkDuplicated(List<Integer> numbers, int number) {
        if (numbers.contains(number))
            throw new IllegalArgumentException("[ERROR] input error");
    }
}
