package lotto.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidation {
    
    public void validatePrice(String price) {
        if (!Pattern.matches("^[1-9][0-9]*0{3}$", price)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateWinningNumbers(String numbers) {
        if (!Pattern.matches("^[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2}$", numbers)) {
            throw new IllegalArgumentException();
        }

        List<Integer> temp = new ArrayList<>();
        List<Integer> winningNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (Integer winningNumber : winningNumbers) {
            if (temp.contains(winningNumber)) {
                throw new IllegalArgumentException();
            }
            if (winningNumber > 45) {
                throw new IllegalArgumentException();
            }
            temp.add(winningNumber);
        }
    }

    public void validateBonusNumber(String number, List<Integer> winningNumbers) {
        if (!Pattern.matches("^[0-9]{1,2}$", number)) {
            throw new IllegalArgumentException();
        }

        int bonusNumber = Integer.parseInt(number);
        if (bonusNumber > 45) {
            throw new IllegalArgumentException();
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
