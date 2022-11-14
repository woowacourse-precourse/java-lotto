package lotto;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NumbersValidator {

    public static void validateWinningNumber(List<Integer> numbers, int bonusNumber){
        validateLotto(numbers);

        if (numbers.contains(bonusNumber)){
            throw new IllegalArgumentException();
        }

    }

    public static void validateLotto(List<Integer> numbers) {
        if (numbers.size() != Lotto.SIZE
                || isOverlapping(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isOverlapping(List<Integer> numbers){
        return numbers.stream().distinct().count() != numbers.size();
    }

    public static void validateMoney(int money) {
        if(!Objects.equals(money % LottoMachine.MONEY_UNIT, 0)){
            throw new IllegalArgumentException();
        }
    }

    public static void isNumeric(String input){
        if (!input.chars().mapToObj(i -> (char)i)
                .allMatch(Character::isDigit)){
            throw new IllegalArgumentException();
        }
    }

    public static void isNumerics(String[] inputs){
       Arrays.stream(inputs)
               .forEach(NumbersValidator::isNumeric);
    }
}
