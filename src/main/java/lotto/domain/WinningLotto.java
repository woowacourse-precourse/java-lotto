package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Preset.*;

public class WinningLotto {

    private final List<Integer> numbersWithBonus;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.numbersWithBonus = createWinningLotto(numbers, bonusNumber);
    }

    public List<Integer> getLottoNumbers() {
        return numbersWithBonus.subList(0, LOTTO_LENGTH);
    }

    public Integer getBonusNumber() {
        return numbersWithBonus.get(LOTTO_LENGTH);
    }

    public static List<Integer> createWinningLotto(List<Integer> numbers, int bonusNumber) {
        List<Integer> lottoNumbers = new ArrayList<>();

        numbers.forEach(number -> addNumber(lottoNumbers, number));
        checkSize(lottoNumbers);

        addNumber(lottoNumbers, bonusNumber);

        return lottoNumbers;
    }

    public static void addNumber(List<Integer> numbers, int number) {
        verifyNumber(numbers, number);
        numbers.add(number);
    }

    public static void verifyNumber(List<Integer> numbers, int number) {
        checkOutOfRange(number);
        checkDuplicated(numbers, number);
    }

    public static void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkOutOfRange(int number) {
        if (number < LOTTO_MIN_VALUE || number > LOTTO_MAX_VALUE)
            throw new IllegalArgumentException(ERROR_FORMAT_MESSAGE);
    }

    public static void checkDuplicated(List<Integer> numbers, int number) {
        if (numbers.contains(number))
            throw new IllegalArgumentException(ERROR_FORMAT_MESSAGE);
    }

    public int countEqualNumber(Lotto userLotto) {
        int count = 0;
        for (int number : this.getLottoNumbers())
            if (userLotto.contains(number)) count++;

        if (count != FIVE_EQUALS)
            return count;

        if (userLotto.contains(this.getBonusNumber()))
            count = SECOND_WINNING;

        return count;
    }
}
