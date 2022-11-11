package domain;

import java.util.List;
import java.util.regex.Pattern;

import static domain.ErrorMessage.*;

public class Validate {

    public void validateMoney(String input) {
        isNumber(input);
        isEnoughMoney(input);
    }

    public static void validateLottoNumber(List<Integer> numbers){
        isDistinctNumber(numbers);
        isLottoSize(numbers);
        for (Integer number : numbers) {
            isLottoRange(number);
        }
    }

    private static void isLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_LOTTO_SIZE_ERROR.getMessage());
        }
    }

    private static void isDistinctNumber(List<Integer> lottoNumber) {
        if(lottoNumber.stream().distinct().count() != lottoNumber.size()){
            throw new IllegalArgumentException(NOT_LOTTO_DISTINCT_NUMBER_ERROR.getMessage());
        }
    }

    private static void isLottoRange(int number){
        if(number < ConstantNumber.MIN_LOTTO_NUMBER.getNumber()
                || number > ConstantNumber.MAX_LOTTO_NUMBER.getNumber()) {
            throw new IllegalArgumentException(NOT_LOTTO_RANGE_ERROR.getMessage());
        }
    }

    private void isEnoughMoney(String input) {
        int money = Integer.parseInt(input);
        if (money % ConstantNumber.VALID_MONEY.getNumber() != 0) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY_ERROR.getMessage());
        }
    }

    private void isNumber(String input) {
        String regex = "^[0-9]*$";
        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR.getMessage());
        }
    }
}
