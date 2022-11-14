package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetValidateInput {
    private final String number;

    public GetValidateInput(String number) {
        this.number = number;
    }

    public int getMoney() {
        try {
            return changeNumberToString(number);
        } catch (IllegalArgumentException e) {
            System.out.println(Error.NOT_IN_RANGE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return changeNumbersToString(number);
    }

    public int getBonus(List<Integer> lotto) {
        try {
            int bonus = changeNumberToString(number);

            validateBonus(bonus, lotto);
            validateInRange(bonus);

            return bonus;
        } catch (IllegalArgumentException e) {
            System.out.println(Error.NOT_IN_RANGE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private int changeNumberToString(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> changeNumbersToString(String number) {
        try {
            return Arrays.stream(number.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBonus(int bonus, List<Integer> lotto) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInRange(int bonus) {
        int maxNumber = 45;
        int minNumber = 1;

        if (minNumber > bonus || bonus > maxNumber) {
            throw new IllegalArgumentException();
        }
    }

}
