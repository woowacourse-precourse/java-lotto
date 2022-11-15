package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Preset.*;

public class WinningLotto {

    private final List<Integer> numbersWithBonus;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {

        this.numbersWithBonus = createWinningLotto(numbers, bonusNumber);
    }

    public List<Integer> getLottoNumber() {
        return numbersWithBonus.subList(0, LOTTO_LENGTH);
    }

    public Integer getBonusNumber() {
        return numbersWithBonus.get(LOTTO_LENGTH);
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
            throw new IllegalArgumentException(ERROR_FORMAT_MESSAGE);
    }

    public static void checkDuplicated(List<Integer> numbers, int number) {
        if (numbers.contains(number))
            throw new IllegalArgumentException(ERROR_FORMAT_MESSAGE);
    }
}
