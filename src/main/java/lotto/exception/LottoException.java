package lotto.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoException {
    private final static int LIMITED_LOTTO_LENGTH = 6;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private final static String ERROR = "[ERROR] ";

    public void isValidLottoNumbers(List<Integer> numbers) {
        checkLottoCount(numbers);
        checkOverlap(numbers);
        checkLottoRange(numbers);
    }

    public void checkLottoCount(List<Integer> numbers) {
        if (numbers.size() != LIMITED_LOTTO_LENGTH) {
            throw new IllegalArgumentException(ERROR + "로또 번호는 6개 입력해주세요.");
        }
    }

    public void checkOverlap(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();
        numbers.stream()
                .map(numberSet::add)
                .collect(Collectors.toList());
        if (numberSet.size() != LIMITED_LOTTO_LENGTH) {
            throw new IllegalArgumentException(ERROR + "번호 중에 중복 번호가 있습니다.");
        }
    }

    public void checkLottoRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ERROR + "로또의 범위는 1~45입니다.");
            }
        }
    }

    public void isValidBonusNumber(List<Integer> numbers, int bonusNumber) {
        checkBonusNumberRange(bonusNumber);
        checkBonusOverlap(numbers, bonusNumber);
    }

    public void checkBonusNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR + "로또의 범위는 1~45입니다.");
        }
    }

    public void checkBonusOverlap(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR + "보너스 번호가 중복됩니다.");
        }
    }

    public void isInputSplit(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            char c = numbers.charAt(i);
            if (!(Character.isDigit(c) || c == ',')) {
                throw new IllegalArgumentException(ERROR + "로또 번호 입력은 숫자와 콤마(,)로 구성되어야 합니다.");
            }
        }
    }

    public void isBonusNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ERROR + "보너스 번호 입력은 숫자로 구성 되어야합니다.");
            }
        }
    }
}