package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        checkRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            Record.printSizeError();
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void checkDuplicate(List<Integer> numbers) {

        List<Integer> visitedNumbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_SIZE; i++) {
            int current = numbers.get(i);

            if (visitedNumbers.contains(current)) {
                Record.printDuplicateError();
                throw new IllegalArgumentException();
            }

            visitedNumbers.add(current);
        }
    }

    private void checkRange(List<Integer> numbers) {

        for (int i = 0; i < LOTTO_SIZE; i++) {
            int current = numbers.get(i);

            if (ReferenceValue.Lotto.START_RANGE.getValue() > current
                    || ReferenceValue.Lotto.END_RANGE.getValue() < current) {
                Record.printRangeError();
                throw new IllegalArgumentException();
            }
        }
    }

    public boolean checkBonusDuplicate(int bonus) {
        if (numbers.contains(bonus)) {
            Record.printBonusDuplicateError();
            return true;
        }
        return false;
    }

    public static List<Integer> getLottoNumbers(String input) {
        List<Integer> lottoNumbers = new ArrayList<>();
        String[] numbers = input.split(",");

        for (int i = 0; i < ReferenceValue.Lotto.SIZE.getValue(); i++) {
            Game.checkNumberError(numbers[i]);
            int number = Integer.valueOf(numbers[i]);
            lottoNumbers.add(number);
        }

        return lottoNumbers;
    }

    public List<Integer> getResult(Lotto winningNumbers, int bonus) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < ReferenceValue.Lotto.SIZE.getValue(); i++) {
            int number = winningNumbers.getLottoNumber(i);
            result = addResult(result, number);
        }

        result = addBonus(result, bonus);

        return result;
    }

    private List<Integer> addBonus(List<Integer> result, int number) {
        if (numbers.contains(number)) {
            result.add(ReferenceValue.Lotto.IS_BONUS.getValue());
        }
        return result;
    }

    private List<Integer> addResult(List<Integer> result, int number) {
        if (numbers.contains(number)) {
            result.add(number);
        }
        return result;
    }

    public Integer getLottoNumber(int LottoIndex) {
        return numbers.get(LottoIndex);
    }

    public String getLotto() {
        return numbers.toString();
    }
}
