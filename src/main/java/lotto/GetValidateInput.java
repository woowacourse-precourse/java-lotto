package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetValidateInput {
    private final String number;
    private static final int moneyUnit = 1000;
    private static final int minNumber = 1;
    private static final int maxNumber = 45;

    public GetValidateInput(String number) {
        this.number = number;
    }

    public int getMoney() {
        int money;
        money = changeNumberToString(number);
        validMoney(money);
        return money;
    }

    public List<Integer> getNumbers() {
        return changeNumbersToString(number);
    }

    public int getBonus(List<Integer> lotto) {
        int bonus;
        bonus = changeNumberToString(number);
        validateBonus(bonus, lotto);
        validateInRange(bonus);
        return bonus;
    }

    private void validMoney(int money) {
        if (money < moneyUnit || money % moneyUnit != 0) {
            throw new IllegalArgumentException(Error.NOT_VALIDATE_MONEY_UNIT.getMessage());
        }
    }

    private int changeNumberToString(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.NOT_NUMBER.getMessage());
        }
    }

    private List<Integer> changeNumbersToString(String number) {
        try {
            return Arrays.stream(number.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.WORNG_INPUT.getMessage());
        }
    }

    private void validateBonus(int bonus, List<Integer> lotto) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException(Error.IS_CONTAIN_BONUS_TO_LOTTO.getMessage());
        }
    }

    private void validateInRange(int bonus) {
        if (minNumber > bonus || bonus > maxNumber) {
            throw new IllegalArgumentException(Error.NOT_IN_RANGE.getMessage());
        }
    }

}
