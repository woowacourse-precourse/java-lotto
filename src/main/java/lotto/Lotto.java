package lotto;

import java.util.*;

public class Lotto {
    private static final int SMALLEST_LOTTERY_NUMBER = 1;
    private static final int BIGGEST_LOTTERY_NUMBER = 45;
    private static final int LOTTERY_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String correctNumbers) {
        List<String> splitted = Arrays.asList(correctNumbers.split(","));
        List<Integer> parsedNumbers = new ArrayList<>();

        try {
            splitted.forEach(x -> parsedNumbers.add(Integer.parseInt(x)));
            numbers = parsedNumbers;
        } catch (NumberFormatException ex) {
            throw (new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_EXCEPTION
                    .toString()));
        }
        validate(numbers);
    }

    private void validateNumberRange(List<Integer> numbers) {
        int i = 0;
        int size = numbers.size() - 1;
        int currentElement = numbers.get(i);

        while (i < size && (SMALLEST_LOTTERY_NUMBER <= currentElement && currentElement <= BIGGEST_LOTTERY_NUMBER)) {
            currentElement = numbers.get(i++);
        }
        if (i != size) {
            throw (new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_EXCEPTION
                    .toString()));
        }
    }

    private void validateUniqueness(List<Integer> numbers, int count) {
        if (new HashSet<>(numbers).size() != count) {
            throw (new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_EXCEPTION
                    .toString()));
        }
    }

    private void validate(List<Integer> numbers) {
        validateNumberRange(numbers);
        validateUniqueness(numbers, LOTTERY_NUMBER_COUNT);
    }

    public void validateBonusNumber(int bonusNumber) {
        List<Integer> numbersIncludingBonus = new ArrayList<>(numbers);

        numbersIncludingBonus.add(bonusNumber);
        validateNumberRange(numbersIncludingBonus);
        validateUniqueness(numbersIncludingBonus, LOTTERY_NUMBER_COUNT + 1);
    }

    public int parseBonusNumber(String bonusNumber) {
        int bonus;

        try {
            bonus = Integer.parseInt(bonusNumber);
            validateBonusNumber(bonus);
            return (bonus);
        } catch (NumberFormatException ex) {
            throw (new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_EXCEPTION
                    .toString()));
        }
    }

    public int checkIfCorrectNumber(int number) {
        if (numbers.contains(number))
            return (1);
        return (0);
    }

    public int countCorrectNumbers(Lotto target) {
        int count = 0;

        for (int number : target.numbers) {
            count += checkIfCorrectNumber(number);
        }
        return (count);
    }

    @Override
    public String toString() {
        return (numbers.toString());
    }

    public String getSortedString() {
        List<Integer> sorted = new ArrayList<>(numbers);

        Collections.sort(sorted);
        return (sorted.toString());
    }
}
